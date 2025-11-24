import java.util.LinkedList;

public class SortedListPQ<K extends Comparable<K>, V> implements PriorityQueue<K, V> {
    private LinkedList<MyEntry<K, V>> list = new LinkedList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void insert(K key, V value) {
        MyEntry<K, V> newEntry = new MyEntry<>(key, value);

        if (list.isEmpty()) {
            list.add(newEntry);
            return;
        }

        int index = 0;
        for (MyEntry<K, V> entry : list) {
            if (newEntry.compareTo(entry) < 0) {
                list.add(index, newEntry);  // Insert in correct sorted position
                return;
            }
            index++;
        }

        list.addLast(newEntry); // If largest, add at end
    }

    public MyEntry<K, V> min() {
        return isEmpty() ? null : list.getFirst(); // O(1)
    }

    public MyEntry<K, V> removeMin() {
        return isEmpty() ? null : list.removeFirst(); // O(1)
    }
}
