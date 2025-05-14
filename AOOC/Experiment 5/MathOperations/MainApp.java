import MathOperations.Floor;
import MathOperations.Ceil;
import MathOperations.Round;

public class MainApp {
    public static void main(String[] args) {
        double num1 = 5.7;
        double num2 = -3.4;

        System.out.println("Operations on " + num1 + ":");
        System.out.println("Floor: " + Floor.apply(num1));
        System.out.println("Ceil : " + Ceil.apply(num1));
        System.out.println("Round: " + Round.apply(num1));

        System.out.println("\nOperations on " + num2 + ":");
        System.out.println("Floor: " + Floor.apply(num2));
        System.out.println("Ceil : " + Ceil.apply(num2));
        System.out.println("Round: " + Round.apply(num2));
    }
}
