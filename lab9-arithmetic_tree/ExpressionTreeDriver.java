public class ExpressionTreeDriver {
    public static void main(String[] args) {
        // root: *
        BinaryTreeNode root = new BinaryTreeNode("*");

        // internal operators
        BinaryTreeNode nodePlus  = new BinaryTreeNode("+");
        BinaryTreeNode nodeMinus = new BinaryTreeNode("-");

        // connect root to children
        root.left  = nodePlus;   nodePlus.parent  = root;
        root.right = nodeMinus;  nodeMinus.parent = root;

        // leaves
        BinaryTreeNode node3 = new BinaryTreeNode("3");
        BinaryTreeNode node7 = new BinaryTreeNode("7");
        BinaryTreeNode node9 = new BinaryTreeNode("9");
        BinaryTreeNode node4 = new BinaryTreeNode("4");

        // connect + subtree
        nodePlus.left = node3;   node3.parent = nodePlus;
        nodePlus.right = node7;  node7.parent = nodePlus;

        // connect - subtree
        nodeMinus.left = node9;  node9.parent = nodeMinus;
        nodeMinus.right = node4; node4.parent = nodeMinus;

        // Traversals
        System.out.println("--- Preorder Traversal (Prefix) ---");
        root.traversePreorder();     // expected: * + 3 7 - 9 4
        System.out.println();

        System.out.println("\n--- Inorder Traversal (Infix) ---");
        root.traverseInorder();      // expected (with parens): ((3 + 7 )*(9 - 4 ))
        System.out.println();

        System.out.println("\n--- Postorder Traversal (Postfix) ---");
        root.traversePostorder();    // expected: 3 7 + 9 4 - *
        System.out.println();
    }
}
