import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10};
        int[] b = {2, 3, 6, 9};

        int[] merged = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j])
                merged[k++] = a[i++];
            else
                merged[k++] = b[j++];
        }

        while (i < a.length)
            merged[k++] = a[i++];

        while (j < b.length)
            merged[k++] = b[j++];

        System.out.println("Merged Sorted Array: " + Arrays.toString(merged));
    }
}
