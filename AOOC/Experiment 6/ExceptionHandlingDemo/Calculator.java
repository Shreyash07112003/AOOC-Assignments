package ExceptionHandlingDemo;

public class Calculator {

    // Method to perform division
    public static double divide(int a, int b) throws DivisionException {
        if (b == 0) {
            throw new DivisionException("Error: Division by zero is not allowed.");
        }
        return (double) a / b;
    }
}
