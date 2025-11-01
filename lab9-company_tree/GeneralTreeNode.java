import java.util.ArrayList;
import java.util.List;

public class GeneralTreeNode {
    String name;
    GeneralTreeNode parent;
    List<GeneralTreeNode> children;

    public GeneralTreeNode(String name) {
        this.name = name;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    public void addChild(GeneralTreeNode child) {
        child.parent = this;
        this.children.add(child);
    }

    // Preorder: visit parent, then children
    public void traversePreorder() {
        System.out.println(this.name);  // Step 1: visit self
        for (GeneralTreeNode child : children) {  // Step 2: visit each child
            child.traversePreorder();
        }
    }

    // Postorder: visit children, then parent
    public void traversePostorder() {
        for (GeneralTreeNode child : children) {  // Step 1: visit each child
            child.traversePostorder();
        }
        System.out.println(this.name);  // Step 2: visit self
    }
}
