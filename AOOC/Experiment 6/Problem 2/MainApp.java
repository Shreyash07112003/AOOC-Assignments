import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        try {
            NumberCheck.checkEvenNumber(number);  // Call the method to check for even/odd
        } catch (OddNumberException e) {
            System.out.println("Error: " + e.getMessage());  // Handle the exception
        }

        sc.close();
    }
}
