// AVLTreeDriver.java
public class AVLTreeDriver {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Sequence that hits single and double rotations:
        // 10, 20, 30 (RR -> left rotate)
        // 5, 4 (LL -> right rotate)
        // 8 (LR -> left-right)
        // 25 (RL -> right-left)
        int[] seq = {10, 20, 30, 5, 4, 8, 25};
        for (int x : seq) tree.insert(x);

        System.out.print("Inorder: ");
        tree.inorder();    // sorted order

        System.out.print("Preorder: ");
        tree.preorder();   // root, left, right

        System.out.print("Postorder: ");
        tree.postorder();  // left, right, root

        // Example expected (may differ by balanced shape but inorder must be sorted):
        // Inorder: 4 5 8 10 20 25 30
    }
}
