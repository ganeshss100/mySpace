package Practice.Tree;

/**
 * Created by gsrinivasagam on 9/30/2018.
 */
public class Tree {
    public TreeNode getRoot() {
        return root;
    }

    private TreeNode root;
    class TreeNode{

        private int data;
        private TreeNode left;
        private TreeNode right;


        public TreeNode(int data,TreeNode left, TreeNode right){
            this.left = left;
            this.data=  data;
            this.right=right;
        }

        public int getData() {
            return data;
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

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode(int data){
            this.data= data;
        }

    }

    public void createSampleTree(){
        this.root = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)), new TreeNode(3,new TreeNode(6),new TreeNode(7)));
    }

    public static void main(String[] args) {
        Tree tree= new Tree();
        tree.createSampleTree();;
        tree.printPreOrder();
    }

    public void printPreOrder(){
        printPreOrder(root);
    }

    public void printPreOrder(TreeNode root){
        if (root==null){
            return;
        }
        System.out.println(root.getData());
        printPreOrder(root.getLeft());
        printPreOrder(root.getRight());
    }

}
