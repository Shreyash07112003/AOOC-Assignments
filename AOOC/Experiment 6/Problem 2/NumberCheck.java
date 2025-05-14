public class NumberCheck {

    // Method to check if the number is odd
    public static void checkEvenNumber(int number) throws OddNumberException {
        if (number % 2 != 0) {
            throw new OddNumberException("The number is odd! Please enter an even number.");
        } else {
            System.out.println("The number is even.");
        }
    }
}
