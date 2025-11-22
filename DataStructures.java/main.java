import java.util.Arrays;// ==========================================
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