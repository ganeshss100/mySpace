package Practice.Tree;

/**
 * Created by gsrinivasagam on 11/15/2018.
 */
public class InOrderTree {

    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    class TreeNode {

        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data, TreeNode left, TreeNode right) {
            super();
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public TreeNode() {
            super();
        }

        public TreeNode(int data) {
            super();
            this.data = data;
        }

        @Override
        public String toString() {
            return data+"";
        }
    }

    public static void main(String[] args) {
        InOrderTree tree = new InOrderTree();
        tree.createSampleTree();
        tree.printInorder();
    }

    /*
     * Create a sample tree
     *              1
     *      2               3
     * 4        5       6       7
     *
     */
    public void createSampleTree() {
        root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
    }

    /*
     * Print inorder traversal
     */
    public void printInorder() {
        printInorder(root);
    }

    private void printInorder(TreeNode root) {
        if(root == null) {
            return;
        }
        printInorder(root.getLeft());
        System.out.print(root.getData() + " ");
        printInorder(root.getRight());
    }
}
