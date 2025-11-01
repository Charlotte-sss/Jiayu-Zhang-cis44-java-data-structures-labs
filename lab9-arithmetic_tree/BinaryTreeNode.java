public class BinaryTreeNode {
    String value;           // operator: + - * /   or operand: "3" "7" ...
    BinaryTreeNode parent;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(String value) {
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    // Preorder: Parent -> Left -> Right   (Prefix)
    public void traversePreorder() {
        System.out.print(this.value + " ");
        if (left != null)  left.traversePreorder();
        if (right != null) right.traversePreorder();
    }

    // Inorder: Left -> Parent -> Right    (Infix, 带括号更清晰)
    public void traverseInorder() {
        boolean isOp = isOperator(this.value);
        if (isOp) System.out.print("(");
        if (left != null)  left.traverseInorder();
        System.out.print(this.value + " ");
        if (right != null) right.traverseInorder();
        if (isOp) System.out.print(")");
    }

    // Postorder: Left -> Right -> Parent  (Postfix / RPN)
    public void traversePostorder() {
        if (left != null)  left.traversePostorder();
        if (right != null) right.traversePostorder();
        System.out.print(this.value + " ");
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
