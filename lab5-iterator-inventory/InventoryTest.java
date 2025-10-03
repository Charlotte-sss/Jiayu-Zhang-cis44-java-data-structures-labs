public class InventoryTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Add items
        inventory.addItem(new Item("item1"));
        inventory.addItem(new Item("item2"));
        inventory.addItem(new Item("item3"));

        System.out.println("Initial Inventory:");
        inventory.display();

        // Combine two items
        System.out.println("\nAttempting to combine item1 and item2...");
        inventory.combineItems("item1", "item2");

        // Display after combination
        System.out.println("\nInventory after combination:");
        inventory.display();

        // Try combining missing items
        System.out.println("\nAttempting to combine item1 and item3...");
        inventory.combineItems("item1", "item3");
    }
}
