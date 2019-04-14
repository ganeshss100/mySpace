package Practice.Tree;

/**
 * Created by gsrinivasagam on 10/3/2018.
 */

public class BinaryTreeMinDepth {

    private TreeNode root;

    public int getMinDepth() {
        return getMinDepth(root);
    }

    private int getMinDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        if(root.left==null && root.right==null){
            return 1;
        }

       int leftDepth = root.left!=null?getMinDepth(root.left): Integer.MAX_VALUE;
        int rightDepth = root.right!=null?getMinDepth(root.right):Integer.MAX_VALUE;

        return 1+Math.min(leftDepth,rightDepth);

    }

    public void createSampleTree() {
        root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n4.right = n8;

        n5.right = n9;

        n7.right = n10;

        n8.left = n11;
    }

    public static void main(String[] args) {
        BinaryTreeMinDepth tree = new BinaryTreeMinDepth();
        tree.createSampleTree();
        System.out.println("Min Depth " + tree.getMinDepth());
    }

}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data, TreeNode left, TreeNode right) {
        super();
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {
        super();
    }

    public TreeNode(int data) {
        super();
        this.data = data;
    }
}
