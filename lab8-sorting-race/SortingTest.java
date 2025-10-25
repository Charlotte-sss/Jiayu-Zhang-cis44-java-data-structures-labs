import java.util.Arrays;
import java.util.Random;

public class SortingTest {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000};

        System.out.println("--- The Sorting Race ---");

        for (int n : sizes) {
            System.out.println("\n=== Testing for array size n = " + n + " ===");

            int[] avg = generateRandomArray(n);
            int[] best = generateSortedArray(n);
            int[] worst = generateReverseSortedArray(n);

            runAndTimeAllSorts(avg, best, worst);
        }
    }

    private static void runAndTimeAllSorts(int[] avg, int[] best, int[] worst) {
        System.out.println("Algorithm\tCase\t\tTime (ms)");

        // Selection Sort
        testOneCase("Selection Sort", avg.clone(), "Average");
        testOneCase("Selection Sort", best.clone(), "Best");
        testOneCase("Selection Sort", worst.clone(), "Worst");

        // Insertion Sort
        testOneCase("Insertion Sort", avg.clone(), "Average");
        testOneCase("Insertion Sort", best.clone(), "Best");
        testOneCase("Insertion Sort", worst.clone(), "Worst");

        // Merge Sort
        testOneCase("Merge Sort", avg.clone(), "Average");
        testOneCase("Merge Sort", best.clone(), "Best");
        testOneCase("Merge Sort", worst.clone(), "Worst");
    }

    private static void testOneCase(String algoName, int[] arr, String caseType) {
        long start = System.nanoTime();

        switch (algoName) {
            case "Selection Sort":
                SortingAlgorithms.selectionSort(arr);
                break;
            case "Insertion Sort":
                SortingAlgorithms.insertionSort(arr);
                break;
            case "Merge Sort":
                SortingAlgorithms.mergeSort(arr);
                break;
        }

        long end = System.nanoTime();
        double elapsedMs = (end - start) / 1_000_000.0;
        System.out.printf("%-15s %-10s %.3f%n", algoName, caseType, elapsedMs);
    }

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size * 10);
        }
        return arr;
    }

    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }
}
