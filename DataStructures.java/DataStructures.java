
import java.util.Arrays;
public class DataStructures {
    // ==========================================
    // 1. RECURSION
    // ==========================================

    /**
     * TODO: Calculate the sum of all integers from 1 to n recursively.
     * Example: sum(5) -> 5 + 4 + 3 + 2 + 1 = 15
     */
    public static int recursiveSum(int n) {
        // 1.BASE CASE: if n is 0 or less, the sum is 0. This stops the recursion.
        if (n <= 0) {
            return 0;
        }
        //2. return the current number (n)+the sum of all numbers up to n-1
        return 0 + recursiveSum(n - 1);
    }
    // ==========================================
    // 2. ANALYSIS OF ALGORITHMS
    // ==========================================

    /**
     * TODO: Find and return the maximum value in an array.
     * Constraint: Try to do this with O(n) time complexity.
     */
    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        IllegalArgumentException("Array must not be empty");
    }

    int max = arr[0];
        for (int i=1; i<arr.length;i++){
        if (arr[i] > max) {
            max= arr[i];
        }
    }
        return max;
}

    // ==========================================
    // 3. TREES
    // ==========================================
    // Simple Node class (Do not modify)
    static class Node {
        int value;
        Node left, right;
        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    /**
     * TODO: Return the total count of nodes in the binary tree.
     * Hint: Use recursion (1 + left count + right count).
     */
    public static int countNodes(Node root) {
        if (root == null) {
            return 0; // Placeholder return
        }
        return 1 +countNodes(root.left) + countNodes(root.right);
    }
    // ==========================================
    // 4. SEARCH ALGORITHMS
    // ==========================================
    /**
     * TODO: Implement Linear Search.
     * Return the index of the target if found, otherwise return -1.
     */
    public static int linearSearch(int[] arr, int target) {
        // TODO: Loop through the array to find the target
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Placeholder return
    }
    // ==========================================
    // 5. SORTING ALGORITHMS
    // ==========================================
    /**
     * TODO: Implement Bubble Sort to sort the array in ascending order.
     * Hint: You need nested loops and a swap logic.
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // TODO: Write the outer and inner loops
        // TODO: Implement the swap condition
        for (inti=0; i<n-1;i++){
            for (int j=0;j<n-1-i;j++){
                if (arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
    }
    // ==========================================
    // TEST DRIVER (Do not modify this part)
    // ==========================================
    public static void main(String[] args) {
        System.out.println("=== Coding Main Data Structures ===\n");
        // ------------------------------------------------------
        // Test 1: Recursion
        // ------------------------------------------------------
        int n = 5;
        int expectedSum = 15;
        int actualSum = recursiveSum(n);
        printTestResult("1. Recursion (Sum)", expectedSum, actualSum);
        // ------------------------------------------------------
        // Test 2: Analysis (Find Max)
        // ------------------------------------------------------
        int[] numbers = {10, 5, 20, 8, 15};
        int expectedMax = 20;
        int actualMax = findMax(numbers);
        printTestResult("2. Analysis (Find Max)", expectedMax, actualMax);
        // ------------------------------------------------------
        // Test 3: Trees (Count Nodes)
        // ------------------------------------------------------
        // Constructing tree: 1
        // / \
        // 2 3
        // /
        // 4
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        int expectedCount = 4;
        int actualCount = countNodes(root);
        printTestResult("3. Trees (Node Count)", expectedCount, actualCount);
        // ------------------------------------------------------
        // Test 4: Search (Linear)
        // ------------------------------------------------------
        int[] searchData = {4, 2, 7, 1, 9};
        int target = 7;
        int expectedIndex = 2;
        int actualIndex = linearSearch(searchData, target);
        printTestResult("4. Search (Linear)", expectedIndex, actualIndex);
        // ------------------------------------------------------
        // Test 5: Sorting (Bubble Sort)
        // ------------------------------------------------------
        int[] sortData = {64, 34, 25, 12, 22, 11, 90};
        String expectedSort = "[11, 12, 22, 25, 34, 64, 90]";
        bubbleSort(sortData);
        String actualSort = Arrays.toString(sortData);
        System.out.println("[Test 5] Sorting (Bubble Sort)");
        System.out.println(" Expected: " + expectedSort);
        System.out.println(" Actual: " + actualSort);
        if (expectedSort.equals(actualSort)) {
            System.out.println(" Result: [PASS]");
        } else {
            System.out.println(" Result: [FAIL]");
        }
        System.out.println();
    }
        // Helper to print results
        private static void printTestResult(String testName, int expected, int actual) {
            System.out.println("[Test] " + testName);
            System.out.println(" Expected: " + expected);
            System.out.println(" Actual: " + actual);
            if (expected == actual) {
                System.out.println(" Result: [PASS]");
            } else {
                System.out.println(" Result: [FAIL]");
            }
            System.out.println();
        }
    }