// TwoFourTree.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Node of a 2-4 tree (aka 2-3-4 tree)
class TwoFourNode {
    List<Integer> keys = new ArrayList<>();         // 1..3 keys
    List<TwoFourNode> children = new ArrayList<>(); // 0,2,3,4 children
    TwoFourNode parent = null;

    boolean isLeaf() { return children.isEmpty(); }
    boolean isFull() { return keys.size() == 3; }

    // Find child index to descend for given key
    TwoFourNode getNextChild(int key) {
        int i = 0;
        while (i < keys.size() && key > keys.get(i)) i++;
        return children.get(i);
    }

    // Insert a key into this node (assumes not full)
    void insertKey(int key) {
        keys.add(key);
        Collections.sort(keys);
    }

    // Insert child at position i
    void insertChild(int index, TwoFourNode child) {
        children.add(index, child);
        if (child != null) child.parent = this;
    }
}

public class TwoFourTree {
    private TwoFourNode root = new TwoFourNode();

    public void insert(int key) {
        TwoFourNode node = root;

        // Top-down: split full root before descent
        if (node.isFull()) {
            splitRoot();
            node = root;
        }

        // Descend, splitting full children on the way down
        while (!node.isLeaf()) {
            int i = 0;
            while (i < node.keys.size() && key > node.keys.get(i)) i++;

            // If the child we're about to go into is full, split it first
            TwoFourNode child = node.children.get(i);
            if (child.isFull()) {
                splitChild(node, i, child);
                // After split, decide which side to go
                if (key > node.keys.get(i)) i++;
            }
            node = node.children.get(i);
        }

        // Now node is a leaf and not full
        node.insertKey(key);
        // If somehow overflowed (shouldn't, due to proactive split), fix upward
        while (node != null && node.keys.size() > 3) {
            split(node);
            node = node.parent;
        }
    }

    // Split when node is known to be full and has a parent
    private void splitChild(TwoFourNode parent, int index, TwoFourNode node) {
        // node has keys [k0, k1, k2]
        int k0 = node.keys.get(0);
        int k1 = node.keys.get(1); // promote
        int k2 = node.keys.get(2);

        TwoFourNode left = new TwoFourNode();
        TwoFourNode right = new TwoFourNode();
        left.keys.add(k0);
        right.keys.add(k2);

        // children redistribution if internal
        if (!node.isLeaf()) {
            // node had up to 4 children: c0 c1 c2 c3
            TwoFourNode c0 = node.children.get(0);
            TwoFourNode c1 = node.children.get(1);
            TwoFourNode c2 = node.children.get(2);
            TwoFourNode c3 = node.children.get(3);

            left.children.add(c0); if (c0 != null) c0.parent = left;
            left.children.add(c1); if (c1 != null) c1.parent = left;
            right.children.add(c2); if (c2 != null) c2.parent = right;
            right.children.add(c3); if (c3 != null) c3.parent = right;
        }

        // insert promoted key and replace child pointers in parent
        parent.keys.add(index, k1);
        // remove the original child and insert two new ones
        parent.children.remove(index);
        parent.insertChild(index, left);
        parent.insertChild(index + 1, right);
    }

    // Split a full root
    private void splitRoot() {
        TwoFourNode oldRoot = root;
        // keys [k0,k1,k2], promote k1
        int k0 = oldRoot.keys.get(0);
        int k1 = oldRoot.keys.get(1);
        int k2 = oldRoot.keys.get(2);

        TwoFourNode left = new TwoFourNode();
        TwoFourNode right = new TwoFourNode();
        left.keys.add(k0);
        right.keys.add(k2);

        if (!oldRoot.isLeaf()) {
            TwoFourNode c0 = oldRoot.children.get(0);
            TwoFourNode c1 = oldRoot.children.get(1);
            TwoFourNode c2 = oldRoot.children.get(2);
            TwoFourNode c3 = oldRoot.children.get(3);

            left.children.add(c0); if (c0 != null) c0.parent = left;
            left.children.add(c1); if (c1 != null) c1.parent = left;
            right.children.add(c2); if (c2 != null) c2.parent = right;
            right.children.add(c3); if (c3 != null) c3.parent = right;
        }

        root = new TwoFourNode();
        root.keys.add(k1);
        root.children.add(left);  left.parent = root;
        root.children.add(right); right.parent = root;
    }

    // Generic split used by post-insert safeguard (rare due to top-down approach)
    private void split(TwoFourNode node) {
        if (node.parent == null) {
            splitRoot();
            return;
        }
        TwoFourNode parent = node.parent;
        int idx = parent.children.indexOf(node);
        splitChild(parent, idx, node);
    }

    // Inorder traversal prints sorted keys
    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(TwoFourNode node) {
        if (node == null) return;

        if (node.isLeaf()) {
            for (int k : node.keys) System.out.print(k + " ");
        } else {
            int i;
            for (i = 0; i < node.keys.size(); i++) {
                inorder(node.children.get(i));
                System.out.print(node.keys.get(i) + " ");
            }
            inorder(node.children.get(i));
        }
    }
}
