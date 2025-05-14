import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.*;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Multithreaded Download Simulator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 500);

            JPanel downloadsPanel = new JPanel();
            downloadsPanel.setLayout(new BoxLayout(downloadsPanel, BoxLayout.Y_AXIS));
            JScrollPane scrollPane = new JScrollPane(downloadsPanel);

            JTextArea logArea = new JTextArea(10, 50);
            logArea.setEditable(false);
            JScrollPane logScroll = new JScrollPane(logArea);

            JButton startButton = new JButton("Start Downloads");
            Logger logger = new Logger(logArea);

            startButton.addActionListener((ActionEvent e) -> {
                downloadsPanel.removeAll();

                // ✅ Verified reliable text URLs
                String[] urls = {
                    "https://www.w3.org/TR/PNG/iso_8859-1.txt",
                    "https://www.learningcontainer.com/wp-content/uploads/2020/04/sample-text-file.txt",
                    "https://www.gutenberg.org/files/1342/1342-0.txt" // File3.txt fixed
                };

                for (int i = 0; i < urls.length; i++) {
                    String fileName = "File" + (i + 1) + ".txt";
                    String fileURL = urls[i];
                    DownloadPanel dp = new DownloadPanel(fileName);
                    downloadsPanel.add(dp);

                    DownloadTask task = new DownloadTask(fileName, fileURL, dp, logger);
                    dp.setDownloadTask(task);
                    new Thread(task).start();
                }

                frame.revalidate();
                frame.repaint();
            });

            frame.setLayout(new BorderLayout());
            frame.add(startButton, BorderLayout.NORTH);
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.add(logScroll, BorderLayout.SOUTH);
            frame.setVisible(true);
        });
    }
}

class Logger {
    private final JTextArea logArea;

    public Logger(JTextArea logArea) {
        this.logArea = logArea;
    }

    public synchronized void log(String message) {
        SwingUtilities.invokeLater(() -> logArea.append(message + "\n"));
    }
}

class DownloadPanel extends JPanel {
    private final JProgressBar progressBar;
    private final JLabel label;
    private final JButton pauseBtn, resumeBtn, cancelBtn;
    private DownloadTask task;

    public DownloadPanel(String fileName) {
        label = new JLabel(fileName);
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        pauseBtn = new JButton("Pause");
        resumeBtn = new JButton("Resume");
        cancelBtn = new JButton("Cancel");

        setLayout(new FlowLayout());
        add(label);
        add(progressBar);
        add(pauseBtn);
        add(resumeBtn);
        add(cancelBtn);

        pauseBtn.addActionListener(e -> {
            if (task != null) task.pause();
        });

        resumeBtn.addActionListener(e -> {
            if (task != null) task.resumeDownload();
        });

        cancelBtn.addActionListener(e -> {
            if (task != null) task.cancel();
        });
    }

    public void updateProgress(int value) {
        progressBar.setValue(value);
    }

    public void setDownloadTask(DownloadTask task) {
        this.task = task;
    }
}

class DownloadTask implements Runnable {
    private final String fileName;
    private final String fileURL;
    private final DownloadPanel panel;
    private final Logger logger;
    private volatile boolean paused = false;
    private volatile boolean cancelled = false;
    private final Object pauseLock = new Object();

    public DownloadTask(String fileName, String fileURL, DownloadPanel panel, Logger logger) {
        this.fileName = fileName;
        this.fileURL = fileURL;
        this.panel = panel;
        this.logger = logger;
    }

    public void pause() {
        paused = true;
        logger.log(fileName + " - Paused");
    }

    public void resumeDownload() {
        synchronized (pauseLock) {
            paused = false;
            pauseLock.notify();
            logger.log(fileName + " - Resumed");
        }
    }

    public void cancel() {
        cancelled = true;
        logger.log(fileName + " - Cancelled");
    }

    @Override
    public void run() {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(fileURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0"); // prevent 403
            connection.setRequestMethod("GET");
            connection.connect();

            int fileSize = connection.getContentLength();
            if (fileSize <= 0) fileSize = 1; // fallback for unknown size

            try (InputStream input = connection.getInputStream();
                 FileOutputStream output = new FileOutputStream(fileName)) {

                byte[] buffer = new byte[1024];
                int totalRead = 0;
                int bytesRead;

                while ((bytesRead = input.read(buffer)) != -1) {
                    synchronized (pauseLock) {
                        while (paused) pauseLock.wait();
                    }

                    if (cancelled) return;

                    output.write(buffer, 0, bytesRead);
                    totalRead += bytesRead;
                    int percent = (int) ((totalRead * 100.0f) / fileSize);
                    if (percent > 100) percent = 100;

                    final int progress = percent;
                    SwingUtilities.invokeLater(() -> panel.updateProgress(progress));
                    logger.log(fileName + " - " + progress + "%");
                }

                logger.log(fileName + " - Download Complete!");
            }
        } catch (Exception e) {
            logger.log(fileName + " - Error: " + e.getMessage());
        } finally {
            if (connection != null) connection.disconnect();
        }
    }
}