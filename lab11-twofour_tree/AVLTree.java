// AVLTree.java

// Node for AVL
class AVLNode {
    int key, height;
    AVLNode left, right;

    AVLNode(int key) {
        this.key = key;
        this.height = 1; // leaf height = 1
        this.left = null;
        this.right = null;
    }
}

public class AVLTree {

    AVLNode root;

    // height helper
    int height(AVLNode n) {
        return (n == null) ? 0 : n.height;
    }

    // max helper
    int max(int a, int b) {
        return a > b ? a : b;
    }

    // balance factor
    int getBalance(AVLNode n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }

    // Right rotate (y becomes right child of x)
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // rotate
        x.right = y;
        y.left = T2;

        // update heights
        y.height = 1 + max(height(y.left), height(y.right));
        x.height = 1 + max(height(x.left), height(x.right));

        return x;
    }

    // Left rotate (x becomes left child of y)
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // rotate
        y.left = x;
        x.right = T2;

        // update heights
        x.height = 1 + max(height(x.left), height(x.right));
        y.height = 1 + max(height(y.left), height(y.right));

        return y;
    }

    // Left-Right = left rotate left child, then right rotate self
    AVLNode leftRightRotate(AVLNode z) {
        z.left = leftRotate(z.left);
        return rightRotate(z);
    }

    // Right-Left = right rotate right child, then left rotate self
    AVLNode rightLeftRotate(AVLNode y) {
        y.right = rightRotate(y.right);
        return leftRotate(y);
    }

    // Public insert
    public void insert(int key) {
        root = insert(root, key);
    }

    // Recursive insert + rebalance
    private AVLNode insert(AVLNode node, int key) {
        if (node == null) return new AVLNode(key);

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            // duplicates not inserted (no change)
            return node;
        }

        // update height
        node.height = 1 + max(height(node.left), height(node.right));

        // check balance
        int bf = getBalance(node);

        // LL
        if (bf > 1 && key < node.left.key) {
            return rightRotate(node);
        }
        // RR
        if (bf < -1 && key > node.right.key) {
            return leftRotate(node);
        }
        // LR
        if (bf > 1 && key > node.left.key) {
            return leftRightRotate(node);
        }
        // RL
        if (bf < -1 && key < node.right.key) {
            return rightLeftRotate(node);
        }

        return node;
    }

    // traversals
    public void inorder() { inorder(root); System.out.println(); }
    private void inorder(AVLNode n) {
        if (n == null) return;
        inorder(n.left);
        System.out.print(n.key + " ");
        inorder(n.right);
    }

    public void preorder() { preorder(root); System.out.println(); }
    private void preorder(AVLNode n) {
        if (n == null) return;
        System.out.print(n.key + " ");
        preorder(n.left);
        preorder(n.right);
    }

    public void postorder() { postorder(root); System.out.println(); }
    private void postorder(AVLNode n) {
        if (n == null) return;
        postorder(n.left);
        postorder(n.right);
        System.out.print(n.key + " ");
    }
}
