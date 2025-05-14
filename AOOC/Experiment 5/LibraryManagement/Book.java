package LibraryManagement;

public class Book {
    private String title;
    private String author;
    private String ISBN;

    // Constructor
    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    // Display book details
    public void display() {
        System.out.println("Book Title : " + title);
        System.out.println("Author     : " + author);
        System.out.println("ISBN       : " + ISBN);
    }
}
