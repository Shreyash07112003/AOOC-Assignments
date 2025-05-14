import java.util.Scanner;
import java.util.Arrays;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[10];

        System.out.println("Enter 10 numbers:");
        for (int i = 0; i < 10; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        System.out.println("Sorted in ascending order:");
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
