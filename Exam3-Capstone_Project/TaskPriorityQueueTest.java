import org.junit.Test;
import static org.junit.Assert.*;

public class TaskPriorityQueueTest {

    @Test
    public void testRemoveMinFromEmpty() {
        TaskPriorityQueue queue = new TaskPriorityQueue();
        Task result = queue.removeMin();
        assertNull("Removing from an empty queue should return null", result);
    }

    @Test
    public void testPriorityOrder() {
        TaskPriorityQueue queue = new TaskPriorityQueue();
        queue.insert(new Task("Pay bills", 1));
        queue.insert(new Task("Prepare presentation", 2));
        queue.insert(new Task("Finish homework", 3));

        assertEquals("Pay bills", queue.removeMin().getDescription());
        assertEquals("Prepare presentation", queue.removeMin().getDescription());
        assertEquals("Finish homework", queue.removeMin().getDescription());
        assertTrue("Queue should now be empty", queue.isEmpty());
    }

    @Test
    public void testSamePriorityTasks() {
        TaskPriorityQueue queue = new TaskPriorityQueue();
        queue.insert(new Task("Task A", 5));
        queue.insert(new Task("Task B", 5));

        Task first = queue.removeMin();
        Task second = queue.removeMin();

        assertNotNull(first);
        assertNotNull(second);
        assertEquals(5, first.getPriority());
        assertEquals(5, second.getPriority());
    }

    @Test
    public void testMinMethod() {
        TaskPriorityQueue queue = new TaskPriorityQueue();
        queue.insert(new Task("Do laundry", 4));
        queue.insert(new Task("Pay bills", 1));

        Task min = queue.min();
        assertNotNull(min);
        assertEquals("Pay bills", min.getDescription());
        assertEquals(1, min.getPriority());
    }
}
