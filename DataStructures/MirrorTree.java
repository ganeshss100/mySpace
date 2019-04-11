package Practice.Tree;

/**
 * Created by gsrinivasagam on 10/4/2018.
 */
public class MirrorTree {

    private TreeNode2 root;

    public void convertToMirror() {
        convertToMirror(root);
    }

    private void convertToMirror(TreeNode2 root) {
        if(root == null) {
            return;
        }
        // Mirror left subtree
        convertToMirror(root.getLeft());
        // Mirror right subtree
        convertToMirror(root.getRight());

        // Interchange left and right subtree root nodes
        TreeNode2 t = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(t);
    }

    /*
     * Create a sample tree
     *                1
     *          2           3
     *      4           5
     *
     */
    public void createSampleTree() {
        root = new TreeNode2(1, new TreeNode2(2, new TreeNode2(4), null), new TreeNode2(3, new TreeNode2(5), null));
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(TreeNode2 root) {
        if(root == null) {
            return;
        }
        inorder(root.getLeft());
        System.out.print(root.getData() + " ");
        inorder(root.getRight());
    }

    public static void main(String[] args) {
        MirrorTree tree = new MirrorTree();
        tree.createSampleTree();
        tree.inorder();
        tree.convertToMirror();
        tree.inorder();
    }
}

class TreeNode2 {

    private int data;
    private TreeNode2 left;
    private TreeNode2 right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode2 getLeft() {
        return left;
    }

    public void setLeft(TreeNode2 left) {
        this.left = left;
    }

    public TreeNode2 getRight() {
        return right;
    }

    public void setRight(TreeNode2 right) {
        this.right = right;
    }

    public TreeNode2(int data) {
        this.data = data;
    }

    public TreeNode2(int data, TreeNode2 left, TreeNode2 right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
