import ExceptionHandlingDemo.Calculator;
import ExceptionHandlingDemo.DivisionException;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter numerator: ");
        int numerator = sc.nextInt();
        System.out.print("Enter denominator: ");
        int denominator = sc.nextInt();

        try {
            double result = Calculator.divide(numerator, denominator);
            System.out.println("Result: " + result);
        } catch (DivisionException e) {
            System.out.println(e.getMessage()); // Display error message if division fails
        } finally {
            sc.close();
        }
    }
}
