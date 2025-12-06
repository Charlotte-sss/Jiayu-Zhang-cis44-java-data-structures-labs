import java.util.ArrayList;

// --- 1. Entry ADT ---
class Entry<K, V> {
    private final K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public V setValue(V value) {
        V old = this.value;
        this.value = value;
        return old;
    }
}

// --- 2. Common Map Interface ---
interface MapADT<K, V> {
    V get(K key);
    V put(K key, V value);
    V remove(K key);
    int size();
    boolean isEmpty();
}

// --- 3. Implementation: Unsorted List Map ---
class UnsortedListMap<K, V> implements MapADT<K, V> {
    private ArrayList<Entry<K, V>> list = new ArrayList<>();

    // Linearly search for the index of the entry with the given key
    private int findEntryIndex(K key) {
        for (int i = 0; i < list.size(); i++) {
            // Assume key is non-null and equals is properly implemented
            if (list.get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public V get(K key) {
        int i = findEntryIndex(key);
        return (i != -1) ? list.get(i).getValue() : null;
    }

    public V remove(K key) {
        int i = findEntryIndex(key);
        if (i != -1) {
            V oldValue = list.get(i).getValue();
            list.remove(i);
            return oldValue;
        }
        return null;
    }

    // --- REQUIRED METHOD: O(n) ---
    public V put(K key, V value) {
        int index = findEntryIndex(key);

        // If key already exists, replace its value and return old value
        if (index != -1) {
            return list.get(index).setValue(value);
        }

        // If key not found, append new Entry and return null
        list.add(new Entry<>(key, value));
        return null;
    }
}

// --- 4. Driver Class (for screenshot output) ---
public class UnsortedListMapDriver {
    public static void main(String[] args) {

        UnsortedListMap<Integer, String> map = new UnsortedListMap<>();

        System.out.println("put(5, A) → " + map.put(5, "A"));
        System.out.println("put(7, B) → " + map.put(7, "B"));
        System.out.println("put(2, C) → " + map.put(2, "C"));
        System.out.println("put(2, E) → " + map.put(2, "E")); // Should print C

        System.out.println("get(7) → " + map.get(7));          // Should print B
        System.out.println("remove(5) → " + map.remove(5));    // Should print A
    }
}
