public interface PriorityQueue<K extends Comparable<K>, V> {
    void insert(K key, V value);
    MyEntry<K, V> removeMin();
    MyEntry<K, V> min();
    boolean isEmpty();
}
