import java.util.ArrayList;
import java.util.LinkedList;

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

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}

// --- 2. Map Interface ---
interface MapADT<K, V> {
    V get(K key);
    V put(K key, V value);
    V remove(K key);
    int size();
    boolean isEmpty();
}

// --- 3. Separate Chaining Hash Map ---
class SeparateChainingMap<K, V> implements MapADT<K, V> {
    private ArrayList<LinkedList<Entry<K, V>>> table;
    private int size = 0;
    private final int N = 11; // prime number table size

    public SeparateChainingMap() {
        table = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            table.add(new LinkedList<Entry<K, V>>());
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % N);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // --- REQUIRED METHOD: get(k) ---
    public V get(K key) {
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    // --- put(k,v) ---
    public V put(K key, V value) {
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        // Check if key already exists
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.setValue(value); // replace old value
            }
        }

        // Key not found → insert at front
        bucket.addFirst(new Entry<>(key, value));
        size++;
        return null;
    }

    // --- remove(k) ---
    public V remove(K key) {
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        Entry<K, V> toRemove = null;
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                toRemove = entry;
                break;
            }
        }

        if (toRemove != null) {
            bucket.remove(toRemove);
            size--;
            return toRemove.getValue();
        }
        return null;
    }
}

// --- 4. Driver for Screenshot Output ---
public class SeparateChainingMapDriver {
    public static void main(String[] args) {

        SeparateChainingMap<String, Integer> map = new SeparateChainingMap<>();

        // Ea and FB produce the SAME hashCode → guaranteed collision
        System.out.println("put(Ea, 100) → " + map.put("Ea", 100));
        System.out.println("put(FB, 200) → " + map.put("FB", 200));
        System.out.println("put(Hello, 300) → " + map.put("Hello", 300));

        System.out.println();

        System.out.println("get(Ea) → " + map.get("Ea"));
        System.out.println("get(FB) → " + map.get("FB"));
        System.out.println("get(Hello) → " + map.get("Hello"));

        System.out.println();

        System.out.println("remove(Ea) → " + map.remove("Ea"));
        System.out.println("get(Ea) after removal → " + map.get("Ea"));
    }
}
