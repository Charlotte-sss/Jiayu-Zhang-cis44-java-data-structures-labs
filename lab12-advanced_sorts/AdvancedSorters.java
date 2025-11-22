import java.util.Arrays;
import java.util.Comparator;

public class AdvancedSorters {

    // --- MergeSort ---
    public static <K> void mergeSort(K[] S, Comparator<? super K> comp) {
        int n = S.length;
        if (n < 2) return;  // Base case

        // Divide
        int mid = n / 2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);
        K[] S2 = Arrays.copyOfRange(S, mid, n);

        // Conquer
        mergeSort(S1, comp);
        mergeSort(S2, comp);

        // Combine
        merge(S, S1, S2, comp);
    }

    private static <K> void merge(K[] S, K[] S1, K[] S2, Comparator<? super K> comp) {
        int i = 0, j = 0, k = 0;

        // Merge elements from S1 and S2 into S
        while (i < S1.length && j < S2.length) {
            if (comp.compare(S1[i], S2[j]) < 0) {
                S[k++] = S1[i++];
            } else {
                S[k++] = S2[j++];
            }
        }

        // Copy remaining elements of S1
        while (i < S1.length) {
            S[k++] = S1[i++];
        }

        // Copy remaining elements of S2
        while (j < S2.length) {
            S[k++] = S2[j++];
        }
    }


    // --- QuickSort ---
    public static <K> void quickSort(K[] S, Comparator<? super K> comp) {
        quickSort(S, comp, 0, S.length - 1);
    }

    private static <K> void quickSort(K[] S, Comparator<? super K> comp, int a, int b) {
        if (a >= b) return;  // Base case

        // Divide: partition the array
        int pivotIndex = partition(S, comp, a, b);

        // Conquer
        quickSort(S, comp, a, pivotIndex - 1);
        quickSort(S, comp, pivotIndex + 1, b);
    }

    private static <K> int partition(K[] S, Comparator<? super K> comp, int a, int b) {
        K pivot = S[b];    // pivot at end
        int left = a;
        int right = b - 1;

        while (left <= right) {
            while (left <= right && comp.compare(S[left], pivot) < 0) {
                left++;
            }
            while (left <= right && comp.compare(S[right], pivot) > 0) {
                right--;
            }
            if (left <= right) {
                // Swap
                K temp = S[left];
                S[left] = S[right];
                S[right] = temp;
                left++;
                right--;
            }
        }

        // Place pivot in final position
        K temp = S[left];
        S[left] = S[b];
        S[b] = temp;

        return left; // pivot final index
    }
}
