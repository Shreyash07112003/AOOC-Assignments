import LibraryManagement.Book;
import LibraryManagement.Member;

public class MainApp {
    public static void main(String[] args) {
        // Create book object
        Book book = new Book("The Alchemist", "Paulo Coelho", "978-0061122415");

        // Create member object
        Member member = new Member("Alice", 1001);

        // Display details
        System.out.println("=== Book Details ===");
        book.display();

        System.out.println("\n=== Member Details ===");
        member.display();
    }
}
