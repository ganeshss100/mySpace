package Practice.Tree;

/**
 * Created by gsrinivasagam on 1/9/2019.
 */
import java.util.HashMap;
import java.util.Map;

public class DiagonalSumTree
{
    private class TreeNode
    {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value)
        {
            this.value = value;
        }
    }

    TreeNode root;

    /*
                             0
                      1              2
                   4      5        3    6
                        7
    */
    public void createTree()
    {
        this.root = new TreeNode(0);

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        root.left  = n1;
        root.right = n2;

        n1.left  =  n4;
        n1.right = n5;

        n2.left  = n3;
        n2.right = n6;

        n5.left = n7;
    }


    private void computeDiagSum(TreeNode currentNode, int currDiag, HashMap<Integer, Integer> diagSum)
    {
        if (currentNode == null)
        {
            return;
        }

        // compute diagonal sum for the tree rooted at the left child
        // left child would be placed in 'currDiag + 1'
        computeDiagSum(currentNode.left, currDiag + 1, diagSum);

        // now add current node's value to its diagonal sum
        int prevSum = (diagSum.get(currDiag) == null) ? 0 : diagSum.get(currDiag) ;
        diagSum.put(currDiag, prevSum + currentNode.value);

        // compute diagonal sum for the tree rooted at the right child
        // right child would be placed in the same diagonal as that of current node
        computeDiagSum(currentNode.right, currDiag, diagSum);
    }

    public void computeDiagSum(HashMap<Integer, Integer> diagSum)
    {
        computeDiagSum(root, 0, diagSum);
    }

    public static void main(String[] args)
    {
        DiagonalSumTree solution = new DiagonalSumTree();

        /*
                                 0
                          1              2
                       4      5        3    6
                            7
        */
        solution.createTree();

        HashMap<Integer, Integer> diagSum = new HashMap();

        // this call populates diagSum HashMap with sum for all diagonals
        solution.computeDiagSum(diagSum);

        // print sum for each diagonal
        for (Map.Entry<Integer, Integer> entry : diagSum.entrySet())
        {
            System.out.println("Diagonal Sum for level " + entry.getKey() + " :" + entry.getValue());
        }
    }
}

