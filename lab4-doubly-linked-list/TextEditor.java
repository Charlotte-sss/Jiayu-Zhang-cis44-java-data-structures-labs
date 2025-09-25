public class TextEditor {
    // Node for doubly linked list
    private static class Node {
        String textState;
        Node prev;
        Node next;

        Node(String textState, Node prev, Node next) {
            this.textState = textState;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node currentNode;

    public TextEditor() {
        // Initial empty document state
        Node initialNode = new Node("", null, null);
        this.currentNode = initialNode;
    }

    // Add new text to the current state
    public void add(String newText) {
        // Build new state by appending to current state
        String updatedText = currentNode.textState + newText;

        // Create new node
        Node newNode = new Node(updatedText, currentNode, null);

        // Clear redo history
        currentNode.next = null;

        // Link and move forward
        currentNode.next = newNode;
        currentNode = newNode;
    }

    // Undo (move one step back in history)
    public String undo() {
        if (currentNode.prev != null) {
            currentNode = currentNode.prev;
            return currentNode.textState;
        } else {
            System.out.println("Nothing to undo.");
            return currentNode.textState;
        }
    }

    // Redo (move one step forward in history)
    public String redo() {
        if (currentNode.next != null) {
            currentNode = currentNode.next;
            return currentNode.textState;
        } else {
            System.out.println("Nothing to redo.");
            return currentNode.textState;
        }
    }

    // Print current text
    public void printCurrent() {
        System.out.println("Current text: \"" + currentNode.textState + "\"");
    }
}
