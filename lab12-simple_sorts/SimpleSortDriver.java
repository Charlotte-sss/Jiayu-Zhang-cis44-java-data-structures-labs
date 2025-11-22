import java.util.Arrays;
import java.util.Comparator;

public class SimpleSortDriver {
    public static void main(String[] args) {
        // Use a standard Integer comparator
        Comparator<Integer> comp = Comparator.naturalOrder();

        // Test 1: Unsorted Array
        Integer[] arr1 = {5, 1, 9, 3, 7, 6};
        Integer[] arr1_copy = Arrays.copyOf(arr1, arr1.length);

        System.out.println("--- Test 1: Unsorted Array ---");
        System.out.println("Original:       " + Arrays.toString(arr1));
        SimpleSorters.bubbleSort(arr1, comp);
        System.out.println("Bubble Sort:    " + Arrays.toString(arr1));

        System.out.println("Original copy:  " + Arrays.toString(arr1_copy));
        SimpleSorters.insertionSort(arr1_copy, comp);
        System.out.println("Insertion Sort: " + Arrays.toString(arr1_copy));
        System.out.println();

        // Test 2: Reverse-Sorted Array (worst case for Insertion Sort)
        Integer[] arr2 = {9, 7, 5, 3, 1};
        Integer[] arr2_copy = Arrays.copyOf(arr2, arr2.length);

        System.out.println("--- Test 2: Reverse-Sorted Array ---");
        System.out.println("Original:       " + Arrays.toString(arr2));
        SimpleSorters.bubbleSort(arr2, comp);
        System.out.println("Bubble Sort:    " + Arrays.toString(arr2));

        System.out.println("Original copy:  " + Arrays.toString(arr2_copy));
        SimpleSorters.insertionSort(arr2_copy, comp);
        System.out.println("Insertion Sort: " + Arrays.toString(arr2_copy));
        System.out.println();

        // Test 3: Already-Sorted Array (best case)
        Integer[] arr3 = {1, 2, 3, 4, 5, 6};
        Integer[] arr3_copy = Arrays.copyOf(arr3, arr3.length);

        System.out.println("--- Test 3: Already-Sorted Array ---");
        System.out.println("Original:       " + Arrays.toString(arr3));
        SimpleSorters.bubbleSort(arr3, comp);
        System.out.println("Bubble Sort:    " + Arrays.toString(arr3));

        System.out.println("Original copy:  " + Arrays.toString(arr3_copy));
        SimpleSorters.insertionSort(arr3_copy, comp);
        System.out.println("Insertion Sort: " + Arrays.toString(arr3_copy));
    }
}
