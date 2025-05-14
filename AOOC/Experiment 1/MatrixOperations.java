import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] A = new int[2][2];
        int[][] B = new int[2][2];
        int[][] result = new int[2][2];

        System.out.println("Enter 2x2 Matrix A:");
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                A[i][j] = sc.nextInt();

        System.out.println("Enter 2x2 Matrix B:");
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                B[i][j] = sc.nextInt();

        System.out.println("\n1. Addition\n2. Multiplication\n3. Transpose of A");
        System.out.print("Choose operation: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                for (int i = 0; i < 2; i++)
                    for (int j = 0; j < 2; j++)
                        result[i][j] = A[i][j] + B[i][j];
                System.out.println("Addition Result:");
                break;

            case 2:
                for (int i = 0; i < 2; i++)
                    for (int j = 0; j < 2; j++)
                        result[i][j] = A[i][0]*B[0][j] + A[i][1]*B[1][j];
                System.out.println("Multiplication Result:");
                break;

            case 3:
                for (int i = 0; i < 2; i++)
                    for (int j = 0; j < 2; j++)
                        result[j][i] = A[i][j];
                System.out.println("Transpose of Matrix A:");
                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        for (int[] row : result) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}
