import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(1000); // initial balance

        while (true) {
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1. Balance Enquiry");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        account.balanceEnquiry();
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmt = sc.nextDouble();
                        account.deposit(depositAmt);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmt = sc.nextDouble();
                        account.withdraw(withdrawAmt);
                        break;
                    case 4:
                        System.out.println("Thank you for using our banking system.");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (LowBalanceException | NegativeNumberException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
