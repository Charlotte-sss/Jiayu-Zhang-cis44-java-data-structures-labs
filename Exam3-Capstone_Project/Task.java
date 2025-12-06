public class Task implements Comparable<Task> {
    private String description;
    private int priority; // smaller number = higher priority

    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Task other) {
        // Min-heap based on priority
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "[Task: " + description + ", priority=" + priority + "]";
    }
}
