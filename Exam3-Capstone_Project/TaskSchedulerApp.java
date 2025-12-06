public class TaskSchedulerApp {

    public static void main(String[] args) {
        TaskPriorityQueue scheduler = new TaskPriorityQueue();

        // Example tasks
        scheduler.insert(new Task("Finish homework", 3));
        scheduler.insert(new Task("Pay bills", 1));
        scheduler.insert(new Task("Prepare presentation", 2));
        scheduler.insert(new Task("Do laundry", 5));

        System.out.println("Processing tasks in priority order:");
        while (!scheduler.isEmpty()) {
            Task next = scheduler.removeMin();
            System.out.println("→ " + next);
        }
    }
}
