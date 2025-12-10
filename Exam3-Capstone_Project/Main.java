public class Main {
    public static void main(String[] args) {
        TaskPriorityQueue queue = new TaskPriorityQueue();

        System.out.println("=== Phase 4: Manual Testing (Main Driver) ===");

        // Test 1: Remove from empty queue
        Task removedFromEmpty = queue.removeMin();
        if (removedFromEmpty == null) {
            System.out.println("Test 1 (empty remove): PASS");
        } else {
            System.out.println("Test 1 (empty remove): FAIL");
        }

        // Test 2: Insert tasks and check order
        queue.insert(new Task("Pay bills", 1));
        queue.insert(new Task("Prepare presentation", 2));
        queue.insert(new Task("Finish homework", 3));

        StringBuilder order = new StringBuilder();
        while (!queue.isEmpty()) {
            Task t = queue.removeMin();
            order.append(t.getDescription()).append(" | ");
        }

        String expectedOrder = "Pay bills | Prepare presentation | Finish homework | ";
        if (order.toString().equals(expectedOrder)) {
            System.out.println("Test 2 (priority order): PASS");
        } else {
            System.out.println("Test 2 (priority order): FAIL");
            System.out.println("  Expected: " + expectedOrder);
            System.out.println("  Actual:   " + order);
        }

        // Test 3: Same priority (tie case)
        TaskPriorityQueue tieQueue = new TaskPriorityQueue();
        tieQueue.insert(new Task("Task A", 5));
        tieQueue.insert(new Task("Task B", 5));

        Task first = tieQueue.removeMin();
        Task second = tieQueue.removeMin();

        if (first != null && second != null &&
                first.getPriority() == 5 && second.getPriority() == 5) {
            System.out.println("Test 3 (same priority tie): PASS");
        } else {
            System.out.println("Test 3 (same priority tie): FAIL");
        }

        System.out.println("=== Manual Tests Finished ===");
    }
}
