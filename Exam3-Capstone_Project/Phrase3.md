// Core implementation for Phase 3 (Min-Heap Task Scheduler)

public void insert(Task task) {
    heap.add(task);
    upheap(heap.size() - 1);   // restore heap order
}

public Task removeMin() {
    if (heap.isEmpty()) return null;

    Task result = heap.get(0);
    Task last = heap.remove(heap.size() - 1);

    if (!heap.isEmpty()) {
        heap.set(0, last);
        downheap(0);           // restore heap order
    }

    return result;
}

// Moves a newly inserted task up until the heap property is correct
private void upheap(int index) {
    while (index > 0) {
        int p = parent(index);
        if (heap.get(p).compareTo(heap.get(index)) <= 0) break;
        swap(p, index);
        index = p;
    }
}

// Moves the root task down after removal until heap order is correct
private void downheap(int index) {
    int size = heap.size();
    while (left(index) < size) {
        int leftIdx = left(index);
        int smallChild = leftIdx;

        int rightIdx = right(index);
        if (rightIdx < size &&
            heap.get(rightIdx).compareTo(heap.get(leftIdx)) < 0) {
            smallChild = rightIdx;
        }

        if (heap.get(index).compareTo(heap.get(smallChild)) <= 0) break;

        swap(index, smallChild);
        index = smallChild;
    }
}
