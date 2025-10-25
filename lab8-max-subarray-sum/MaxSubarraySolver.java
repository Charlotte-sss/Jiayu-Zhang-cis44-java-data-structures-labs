public class MaxSubarraySolver {

    /**
     * Finds the maximum subarray sum using a brute-force approach.
     *
     * Idea:
     *   Fix a starting index i, then extend the end index j >= i while
     *   maintaining a running sum. This avoids the O(n^3) triple-loop
     *   and keeps the algorithm at O(n^2).
     *
     * Primitive operation counting (high level):
     *   Outer loop i : runs n times
     *   Inner loop j : runs (n - i) times on iteration i
     *     - Each inner iteration does:
     *         1 addition (sum += arr[j])            -> O(1)
     *         1 comparison (maxSum = Math.max...)   -> O(1)
     *     So ~ 2 primitive ops per (i, j) pair (ignoring a few constant-cost
     *     assignments and loop increments).
     *   Total (dominant term): sum_{i=0}^{n-1} (n - i) = n(n+1)/2 = Θ(n^2)
     * Therefore, time complexity is O(n^2). Space complexity is O(1).
     *
     * Theoretical Complexity: O(n^2)
     */
    public static int bruteForceMaxSum(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("Empty array");
        int n = arr.length;
        int maxSum = arr[0];
        for (int i = 0; i < n; i++) {
            int running = 0;                   // reset for each i
            for (int j = i; j < n; j++) {
                running += arr[j];             // 1 primitive op (addition)
                if (running > maxSum) {        // 1 primitive op (comparison)
                    maxSum = running;          // (optional assignment)
                }
            }
        }
        return maxSum;
    }

    /**
     * Finds the maximum subarray sum using Kadane's Algorithm.
     *
     * Idea:
     *   Dynamic programming / running best:
     *     curr = max(arr[i], curr + arr[i])
     *     best = max(best, curr)
     *
     * Primitive operation counting (high level):
     *   Single pass of length n:
     *     Per element:
     *       - one addition (curr + arr[i])
     *       - two comparisons (max of two values; then update best)
     *       - a couple of assignments
     *   So O(c * n) primitive operations for some constant c.
     * Therefore, time complexity is O(n). Space complexity is O(1).
     *
     * Theoretical Complexity: O(n)
     */
    public static int kadanesAlgorithmMaxSum(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("Empty array");
        int curr = arr[0];
        int best = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // curr = max(arr[i], curr + arr[i])
            curr = Math.max(arr[i], curr + arr[i]);
            // best = max(best, curr)
            best = Math.max(best, curr);
        }
        return best;
    }
}
