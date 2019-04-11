package Practice.Tree;

/**
 * Created by gsrinivasagam on 1/2/2019.
 */

import java.util.ArrayList;

public class RootToLeafPathsTest {
    public static void main(String[] args) {
        Tree1 tree = new Tree1();
        tree.createSampleTree();
        tree.printRootToLeafPaths();
    }
}

class Tree1 {

    private TreeNode3 root;

    public TreeNode3 getRoot() {
        return root;
    }

    public void printRootToLeafPaths() {
        if(root == null) {
            return;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        printRootToLeafPaths(root, path);
    }

    private void printRootToLeafPaths(TreeNode3 root, ArrayList<Integer> path) {
        path.add(root.getData());

        if(root.getLeft() == null && root.getRight() == null) {
            printList(path);
            return;
        }
        printRootToLeafPaths(root.getLeft(),new ArrayList<Integer>(path));
        printRootToLeafPaths(root.getRight(),new ArrayList<Integer>(path));
    }

    private void printList(ArrayList<Integer> path) {
        for(Integer i: path) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void setRoot(TreeNode3 root) {
        this.root = root;
    }

    /*
     * Create a sample tree
     *              1
     *      2               3
     * 4        5       6       7
     */
    public void createSampleTree() {
        root = new TreeNode3(1, new TreeNode3(2, new TreeNode3(4), new TreeNode3(5)), new TreeNode3(3, new TreeNode3(6), new TreeNode3(7)));
    }
}

class TreeNode3 {

    private int data;
    private TreeNode3 left;
    private TreeNode3 right;

    public TreeNode3(int data, TreeNode3 left, TreeNode3 right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public TreeNode3(int i) {
        data = i;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode3 getLeft() {
        return left;
    }

    public void setLeft(TreeNode3 left) {
        this.left = left;
    }

    public TreeNode3 getRight() {
        return right;
    }

    public void setRight(TreeNode3 right) {
        this.right = right;
    }
}
