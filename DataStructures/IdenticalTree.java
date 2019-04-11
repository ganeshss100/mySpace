package Practice.Tree;

/**
 * Created by gsrinivasagam on 10/4/2018.
 */

public class IdenticalTree {

    public static boolean areIdenticalTrees(TreeNode1 root1, TreeNode1 root2) {
        // If both the tree nodes are null, then both are identical
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 != null && root2 != null) {
            // Check if the 2 nodes have same data and recursively check if left and right subtrees are identical
            return ((root1.getData() == root2.getData()) &&
                    (areIdenticalTrees(root1.getLeft(), root2.getLeft()) &&
                            (areIdenticalTrees(root1.getRight(), root2.getRight()))));


        }
        // If either of root1 or root2 is null but not both, then the trees are not identical
        return false;
    }

    /*
     * Create a sample tree
     *              1
     *      2               3
     * 4        5       6       7
     * 
     */
    public static TreeNode1 createSampleTree() {
        return new TreeNode1(1, new TreeNode1(2, new TreeNode1(4), new TreeNode1(5)), new TreeNode1(3, new TreeNode1(6), new TreeNode1(7)));
    }

    public static void main(String[] args) {
        TreeNode1 t1 = IdenticalTree.createSampleTree();
        TreeNode1 t2 = IdenticalTree.createSampleTree();
        System.out.println(IdenticalTree.areIdenticalTrees(t1, t2) ? "The trees are identical" : " The trees are not identical");
    }
}

class TreeNode1 {

    private int data;
    private TreeNode1 left;
    private TreeNode1 right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode1 getLeft() {
        return left;
    }

    public void setLeft(TreeNode1 left) {
        this.left = left;
    }

    public TreeNode1 getRight() {
        return right;
    }

    public void setRight(TreeNode1 right) {
        this.right = right;
    }

    public TreeNode1(int data) {
        this.data = data;
    }

    public TreeNode1(int data, TreeNode1 left, TreeNode1 right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}