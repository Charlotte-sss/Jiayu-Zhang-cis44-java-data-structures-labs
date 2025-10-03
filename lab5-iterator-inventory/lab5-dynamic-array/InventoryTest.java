public class InventoryTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Add items
        inventory.addItem(new Item("Stick"));
        inventory.addItem(new Item("Stone"));
        inventory.addItem(new Item("Feather"));

        System.out.println("Initial Inventory:");
        inventory.display();

        // Combine two items
        System.out.println("\nAttempting to combine Stick and Stone...");
        inventory.combineItems("Stick", "Stone");

        // Display after combination
        System.out.println("\nInventory after combination:");
        inventory.display();

        // Try combining missing items
        System.out.println("\nAttempting to combine Stick and Feather...");
        inventory.combineItems("Stick", "Feather");
    }
}
