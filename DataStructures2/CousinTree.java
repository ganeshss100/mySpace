package Practice.Tree;

/**
 * Created by gsrinivasagam on 1/5/2019.
 */
public class CousinTree {

        private NodeBST root;

        public void setRoot(NodeBST root) {
            this.root = root;
        }

        /*
         * Condition for cousins:
         * 1: Given nodes are not siblings.
         * 2: Given nodes should be on the same level.
         */
        public Boolean isCousin(NodeBST a, NodeBST b) {
            // A node cannot be cousin of itself.
            if (a == b) {
                return false;
            }
            return (!isSibling(a, b) && getLevel(a) == getLevel(b));
        }

        public int getLevel(NodeBST a) {
            return getLevel(root, a, 1);
        }

        private int getLevel(NodeBST root, NodeBST a, int currLevel) {
            if (root == null)
                return 0;
            if (root == a)
                return currLevel;
            int level = getLevel(root.left, a, currLevel + 1);
            if (level != 0) {
                return level;
            } else
                return getLevel(root.right, a, currLevel + 1);
        }

        public boolean isSibling(NodeBST a, NodeBST b) {
            return isSibling(root, a, b);
        }

        private boolean isSibling(NodeBST root, NodeBST a, NodeBST b) {
            if (root == null)
                return false;
            return ((root.left == a && root.right == b) || (root.right == a && root.left == b) ||
                    isSibling(root.left, a, b) || isSibling(root.right, a, b));
        }

        public static void main(String[] args) {
            CousinTree tree = new CousinTree();
        /*
         * Create a sample tree
         *
         *         1
         *       /   \
         *      2     3
         *     / \   / \
         *    4   5 6   7
         */
            NodeBST root = new NodeBST(1);
            NodeBST n2 = new NodeBST(2);
            NodeBST n3 = new NodeBST(3);
            NodeBST n4 = new NodeBST(4);
            NodeBST n5 = new NodeBST(5);
            NodeBST n6 = new NodeBST(6);
            NodeBST n7 = new NodeBST(7);

            root.left = n2;
            root.right = n3;

            n2.left = n4;
            n2.right = n5;

            n3.left = n6;
            n3.right = n7;
            tree.setRoot(root);
            System.out.println("Nodes " + n5.data + " and " + n6.data + (tree.isCousin(n5, n6) ? " are cousins." : " are not cousins."));
        }
    }

    class NodeBST {

        int data;
        NodeBST left;
        NodeBST right;

        public NodeBST(int data, NodeBST left, NodeBST right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public NodeBST(int data) {
            this.data = data;
        }

}
