import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void display() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory:");
            for (Item item : items) {
                System.out.println("- " + item);
            }
        }
    }

    public void combineItems(String name1, String name2) {
        boolean found1 = false;
        boolean found2 = false;

        Iterator<Item> iter = items.iterator();
        while (iter.hasNext()) {
            Item current = iter.next();
            if (current.getName().equals(name1) && !found1) {
                found1 = true;
                iter.remove(); // safe removal
            } else if (current.getName().equals(name2) && !found2) {
                found2 = true;
                iter.remove(); // safe removal
            }
        }

        if (found1 && found2) {
            String newItemName = name1 + " + " + name2; // simple rule
            Item combined = new Item(newItemName);
            items.add(combined);
            System.out.println("Combined " + name1 + " and " + name2 + " into " + combined.getName());
        } else {
            System.out.println("Could not find both items: " + name1 + " and " + name2);
        }
    }
}
