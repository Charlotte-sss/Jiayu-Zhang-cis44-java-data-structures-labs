import java.util.ArrayList;

public class TaskPriorityQueue {
    // Min-heap of Task objects
    private ArrayList<Task> heap = new ArrayList<>();

    // ----- Helper index methods -----
    private int parent(int index) { return (index - 1) / 2; }
    private int left(int index)   { return 2 * index + 1; }
    private int right(int index)  { return 2 * index + 2; }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    // ----- Core heap operations -----

    public void insert(Task task) {
        heap.add(task);               // add at the end
        upheap(heap.size() - 1);      // restore heap-order by bubbling up
    }

    public Task min() {
        return isEmpty() ? null : heap.get(0);
    }

    public Task removeMin() {
        if (isEmpty()) return null;

        Task result = heap.get(0);
        Task last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            downheap(0);              // restore heap-order by bubbling down
        }

        return result;
    }

    // ----- Private helper: swap -----
    private void swap(int i, int j) {
        Task temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // ----- upheap: restore heap-order bottom → top -----
    private void upheap(int index) {
        while (index > 0) {
            int p = parent(index);
            if (heap.get(p).compareTo(heap.get(index)) <= 0) {
                break; // heap-order satisfied
            }
            swap(p, index);
            index = p;
        }
    }

    // ----- downheap: restore heap-order top → bottom -----
    private void downheap(int index) {
        int size = heap.size();

        while (left(index) < size) { // has at least a left child
            int leftIndex = left(index);
            int smallChildIndex = leftIndex;

            int rightIndex = right(index);
            if (rightIndex < size &&
                    heap.get(rightIndex).compareTo(heap.get(leftIndex)) < 0) {
                smallChildIndex = rightIndex; // right child is smaller
            }

            // if parent <= smallest child, heap-order is satisfied
            if (heap.get(index).compareTo(heap.get(smallChildIndex)) <= 0) {
                break;
            }

            swap(index, smallChildIndex);
            index = smallChildIndex; // move down
        }
    }
}
