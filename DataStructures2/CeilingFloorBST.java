package Practice.Tree;

/**
 * Created by gsrinivasagam on 1/9/2019.
 */
import java.util.LinkedList;

public class CeilingFloorBST
{
    final static int INVALID_VALUE = -1;

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

    // default value for root node is 5
    CeilingFloorBST()
    {
        this.root = new BinarySearchTreeNode(5);
    }

    CeilingFloorBST(int rootValue)
    {
        this.root = new BinarySearchTreeNode(rootValue);
    }


    int getCeiling(BinarySearchTreeNode currentNode, int key)
    {
        if (currentNode == null)
        {
            return INVALID_VALUE;
        }

        int ceiling;

        if (currentNode.data == key)
        {
            ceiling = currentNode.data;
        }

        // if currentNode is less than the key for which ceiling is to be found,
        // then we must search for the ceiling in the right sub-tree
        else if (currentNode.data < key)
        {
            ceiling = getCeiling(currentNode.right, key);
        }

        // if currentNode is greater than key, then we first search for ceiling in the left sub-tree
        // if not found then the currentNode must be the ceiling for this key
        else
        {
            ceiling = getCeiling(currentNode.left, key);
            if (ceiling == INVALID_VALUE)
            {
                ceiling = currentNode.data;
            }
        }

        return ceiling;
    }

    int getCeiling(int key)
    {
        return getCeiling(root, key);
    }


    int getFloor(BinarySearchTreeNode currentNode, int key)
    {
        if (currentNode == null)
        {
            return INVALID_VALUE;
        }

        int floor;

        if (currentNode.data == key)
        {
            floor = currentNode.data;
        }

        // if currentNode is less than key then we might find floor in right sub-tree
        // if not found then currentNode itself must be the floor
        else if (currentNode.data < key)
        {
            floor = getFloor(currentNode.right, key);
            if (floor == INVALID_VALUE)
            {
                floor = currentNode.data;
            }
        }

        // if currentNode is greater than key then we must search for the floor in left sub-tree
        else
        {
            floor = getFloor(currentNode.left, key);
        }
        return floor;
    }

    int getFloor(int key)
    {
        return getFloor(root, key);
    }


    private BinarySearchTreeNode insert(BinarySearchTreeNode node, int key)
    {

        if (node == null) // base case
        {
            node = new BinarySearchTreeNode(key);
        }

        if (key < node.data) // insert key into left sub-tree
        {
            node.left = insert(node.left, key);
        }
        else if (key > node.data) // insert key into right sub-tree
        {
            node.right = insert(node.right, key);
        }

        return node;
    }


    public void insert(int key)
    {
        root = insert(this.root, key);
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
        // dataset : {0,2,4,6,8,9}

        CeilingFloorBST tree = new CeilingFloorBST(6);

        tree.insert(2);
        tree.insert(9);
        tree.insert(0);
        tree.insert(4);
        tree.insert(8);

        /*
         *        6
         *     2     9
         *   0   4  8
         *
        */
        tree.printTreeLevelOrder();

        System.out.print("\n");

        System.out.println("\nCeiling of value '3' in the above BST is: "+ tree.getCeiling(3));
        System.out.println("Floor of value '10' in the above BST is: " + tree.getFloor(10));
    }
}