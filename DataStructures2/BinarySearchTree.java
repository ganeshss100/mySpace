package Practice.Tree;
import java.util.LinkedList;
/**
 * Created by gsrinivasagam on 1/22/2019.
 */
public class BinarySearchTree
{

    private class QueueNode
    {
        BinarySearchTreeNode treeNode;
        int level;

        QueueNode(BinarySearchTreeNode treeNode, int level)
        {
            this.treeNode = treeNode;
            this.level = level;
        }
    }

    private class BinarySearchTreeNode
    {
        int data;
        BinarySearchTreeNode left;
        BinarySearchTreeNode right;

        BinarySearchTreeNode(int data)
        {
            this.data = data;
        }
    }

    BinarySearchTreeNode root;

    // default value for root node is 9
    BinarySearchTree()
    {
        this.root = new BinarySearchTreeNode(9);
    }

    BinarySearchTree(int rootValue)
    {
        this.root = new BinarySearchTreeNode(rootValue);
    }


    int getMinValue(BinarySearchTreeNode node)
    {
        // though this case should not be hit ever for the usecase this function is employed for
        if (node == null) return Integer.MIN_VALUE;

        // if this is the left-most node
        if (node.left == null) return node.data;

        return getMinValue(node.left);
    }


    private BinarySearchTreeNode delete(BinarySearchTreeNode node, int key)
    {
        // if empty tree or key not found
        if (node == null) return null;

        if (key < node.data) // search key in left sub-tree
        {
            node.left = delete(node.left, key);
        }
        else if (key > node.data) // search key in right sub-tree
        {
            node.right = delete(node.right, key);
        }

        else // key to be deleted is equal to node data
        {
            // one child/no child case
            if (node.left == null)
            {
                node = node.right;
            }
            else if (node.right == null)
            {
                node = node.left;
            }

            // two children case
            // copy value of inorder successor into the current node and delete inorder successor
            // since right sub-tree would be modified, update node.right
            else
            {
                int inorderSuccessorValue = getMinValue(node.right);
                node.data = inorderSuccessorValue;
                node.right = delete(node.right, inorderSuccessorValue);
            }
        }

        return node;
    }


    private BinarySearchTreeNode insert(BinarySearchTreeNode node, int key)
    {

        if (node == null) // base case
        {
            return new BinarySearchTreeNode(key);
        }

        if (key < node.data) // insert key into left sub-tree
        {
            node.left = insert(node.left, key);
        }
        else if (key > node.data) // insert key into right sub-tree
        {
            node.right = insert(node.right, key);
        }
        else // key already present in BST
        {
            return node;
        }

        return node;
    }


    public void insert(int key)
    {
        root = insert(this.root, key);
        return;
    }


    public void delete(int key)
    {
        root = delete(this.root, key);
        return;
    }


    public void printTreeLevelOrder()
    {
        if (root == null) return;

        LinkedList queue = new LinkedList();
        queue.add(new QueueNode(root, 0));

        int maxLevelVisited = -1;

        while (!queue.isEmpty())
        {
            QueueNode currentNode = (QueueNode) queue.remove();

            if (currentNode.level > maxLevelVisited)
            {
                maxLevelVisited = currentNode.level;
                System.out.print("\nlevel-" + currentNode.level + " nodes: ");
            }
            System.out.print(" " + currentNode.treeNode.data);

            if (currentNode.treeNode.left != null)
            {
                queue.add(new QueueNode(currentNode.treeNode.left, currentNode.level + 1));
            }

            if (currentNode.treeNode.right != null)
            {
                queue.add(new QueueNode(currentNode.treeNode.right, currentNode.level + 1));
            }
        }
    }


    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree(3);

        tree.insert(1);
        tree.insert(5);
        tree.insert(0);
        tree.insert(2);
        tree.insert(4);

        /*
         *        3
         *     1     5
         *   0   2  4
         *
        */

        System.out.print("BinarySearch tree before deleting any key");
        tree.printTreeLevelOrder();

        tree.delete(3);

        /*
         *        4
         *     1     5
         *   0   2
         *
        */

        System.out.print("\n\nBinarySearch tree after deleting keys - 3");
        tree.printTreeLevelOrder();
    }
}
