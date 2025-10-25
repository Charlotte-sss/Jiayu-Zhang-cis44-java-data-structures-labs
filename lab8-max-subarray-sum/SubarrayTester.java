import java.util.Random;
import java.util.Arrays;

public class SubarrayTester {

    // Choose sizes to highlight the growth gap.
    // Note: O(n^2) brute force becomes impractical above ~20k–30k on typical laptops.
    private static final int[] SIZES = {1000, 5000, 10000, 20000, 50000, 100000};

    // Safety cutoff so your run finishes in a sane time.
    // Brute-force will be skipped for n > BRUTE_FORCE_MAX_N.
    private static final int BRUTE_FORCE_MAX_N = 20000;

    // Repeat timings and take the median to smooth noise.
    private static final int TRIALS = 3;

    public static void main(String[] args) {
        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");
        System.out.println("CSV header:");
        System.out.println("n,bruteForceMillis,kadaneMillis");

        // (Optional) quick correctness check on a small array
        quickCorrectnessCheck();

        for (int n : SIZES) {
            int[] data = generateRandomArrayWithNegatives(n, 12345); // fixed seed for reproducibility

            // Time Kadane on full set
            long kadaneMs = medianTimeMs(() -> MaxSubarraySolver.kadanesAlgorithmMaxSum(data), TRIALS);

            // Time brute force if under cutoff, else mark as skipped
            Long bruteMs = null;
            if (n <= BRUTE_FORCE_MAX_N) {
                bruteMs = medianTimeMs(() -> MaxSubarraySolver.bruteForceMaxSum(data), TRIALS);
                // Optional guard to ensure both return same answer at feasible sizes
                int bf = MaxSubarraySolver.bruteForceMaxSum(data);
                int kd = MaxSubarraySolver.kadanesAlgorithmMaxSum(data);
                if (bf != kd) {
                    System.err.println("Mismatch detected at n=" + n + " -> brute=" + bf + ", kadane=" + kd);
                }
            }

            // Console summary
            System.out.println(n + "," + (bruteMs == null ? "SKIPPED" : bruteMs) + "," + kadaneMs);
        }

        System.out.println("\nNotes:");
        System.out.println("- 'SKIPPED' means brute-force was omitted due to cutoff (" + BRUTE_FORCE_MAX_N + ").");
        System.out.println("- Copy the CSV lines above into a file (e.g., results.csv) for plotting.");
    }

    /** Generate random ints in [-1000, 1000] (inclusive of bounds). */
    public static int[] generateRandomArrayWithNegatives(int size, long seed) {
        Random rng = new Random(seed);
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            // Uniformly sample integers in range [-1000, 1000]
            a[i] = rng.nextInt(2001) - 1000;
        }
        return a;
    }

    /** Measure one run of fn in milliseconds, using System.nanoTime(). */
    private static long timeOnceMs(Runnable fn) {
        long t0 = System.nanoTime();
        fn.run();
        long t1 = System.nanoTime();
        return (t1 - t0) / 1_000_000L;
    }

    /** Run fn 'trials' times and return the median time in ms. */
    private static long medianTimeMs(Runnable fn, int trials) {
        long[] times = new long[trials];
        for (int i = 0; i < trials; i++) {
            // Warm-up call (small input) can be done prior if desired; here we just run repeatedly.
            times[i] = timeOnceMs(fn);
        }
        Arrays.sort(times);
        return times[times.length / 2];
    }

    /** Small correctness smoke test using the example from the prompt. */
    private static void quickCorrectnessCheck() {
        int[] ex = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int bf = MaxSubarraySolver.bruteForceMaxSum(ex);
        int kd = MaxSubarraySolver.kadanesAlgorithmMaxSum(ex);
        if (bf != 6 || kd != 6) {
            throw new AssertionError("Expected 6 for example array, got brute=" + bf + ", kadane=" + kd);
        }
    }
}
