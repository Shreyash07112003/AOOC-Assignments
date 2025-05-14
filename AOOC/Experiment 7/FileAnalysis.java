import java.io.*;

public class FileAnalysis {

    public static void main(String[] args) {
        // Specify the path of the file (adjust the file path accordingly)
        String filePath = "sample.txt"; // Modify this to your file path

        // Initialize counters
        int vowelCount = 0;
        int wordCount = 0;
        int aCount = 0;

        // Read the file and process it
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Loop through each line in the file
            while ((line = br.readLine()) != null) {
                // Count vowels and occurrences of 'a'
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);

                    // Count vowels (case insensitive)
                    if ("aeiouAEIOU".indexOf(ch) != -1) {
                        vowelCount++;
                    }

                    // Count occurrences of 'a' (case insensitive)
                    if (ch == 'a' || ch == 'A') {
                        aCount++;
                    }
                }

                // Split the line into words and count them
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            // Display the results
            System.out.println("Total number of vowels: " + vowelCount);
            System.out.println("Total number of words: " + wordCount);
            System.out.println("Number of times 'a' appears: " + aCount);

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
