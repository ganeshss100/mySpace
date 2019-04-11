package Practice.Tree;

import java.util.*;

/**
 * Created by gsrinivasagam on 10/4/2018.
 */
public class PrintBinaryTreeVerticalOrder {

    class QueueEntry
    {
        TreeNode node;
        int horizontalDistance;
        QueueEntry(TreeNode node, int horizontalDistance)
        {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }

    class TreeNode
    {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int x)
        {
            this.val = x;
        }
    }

    TreeNode root;

    private void fillUpVerticalOrderMap(TreeNode currentNode, int horizontalDistFromRoot, Map verticalOrderMap)
    {
        if (currentNode == null) return;

        ArrayList<Integer> mapEntry;
        LinkedList<QueueEntry> queue = new LinkedList();

        queue.add(new QueueEntry(currentNode, horizontalDistFromRoot));

        while (!queue.isEmpty())
        {
            QueueEntry entry = queue.remove();

            // update verticalOrderMap with current node entry
            mapEntry = (ArrayList<Integer>) verticalOrderMap.get(entry.horizontalDistance);

            if (mapEntry != null) // if node exists at same horizontal distance from root, update the nodeList
            {
                mapEntry.add(entry.node.val);
                verticalOrderMap.put(entry.horizontalDistance, mapEntry);
            }
            else // create a new list for this horizontal distance
            {
                mapEntry = new ArrayList();
                mapEntry.add(entry.node.val);
                verticalOrderMap.put(entry.horizontalDistance, mapEntry);
            }

            // we don't want to adding null nodes into the queue
            if (entry.node.left != null)
            {
                // left child would have horizontal distance = parent's horizontal distance - 1
                queue.add(new QueueEntry(entry.node.left, entry.horizontalDistance - 1));
            }

            if (entry.node.right != null)
            {
                // right child would have horizontal distance = parent's horizontal distance + 1
                queue.add(new QueueEntry(entry.node.right, entry.horizontalDistance + 1));
            }
        }
    }


    public void printVerticalOrder()
    {
        Map<Integer, ArrayList<Integer>> verticalOrderMap = new TreeMap<>();

        fillUpVerticalOrderMap(root, 0, verticalOrderMap);

        // print map entries to print the top view
        Iterator<Map.Entry<Integer, ArrayList<Integer>>> iterator = verticalOrderMap.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<Integer, ArrayList<Integer>> mapEntry = iterator.next();
            ArrayList<Integer> nodeList = mapEntry.getValue();
            for (int i = 0; i < nodeList.size(); i++)
            {
                System.out.print("  " + nodeList.get(i));
            }
            System.out.println("");
        }
    }


    public TreeNode createTree()
    {
        this.root = new TreeNode(3);
        TreeNode n1   = new TreeNode(4);
        TreeNode n2   = new TreeNode(5);
        TreeNode n3   = new TreeNode(6);
        TreeNode n4   = new TreeNode(7);
        TreeNode n5   = new TreeNode(8);
        TreeNode n6   = new TreeNode(9);
        TreeNode n7   = new TreeNode(1);

        root.left  = n1;
        root.right = n2;

        n1.left  = n3;
        n1.right = n4;

        n2.left  = n5;
        n2.right = n6;

        n4.right = n7;

        return root;
    }


    public static void main(String[] arg)
    {
        PrintBinaryTreeVerticalOrder tree = new PrintBinaryTreeVerticalOrder();

        /*
                    3
              4           5
            6   7       8   9
                  1
         */

        tree.createTree();
        tree.printVerticalOrder();
    }
}


