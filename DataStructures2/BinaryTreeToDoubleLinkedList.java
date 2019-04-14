package Practice.Tree;

/**
 * Created by gsrinivasagam on 1/18/2019.
 */
public class BinaryTreeToDoubleLinkedList {

        private Node1 root;

        public Node1 convertToDoublyLinkedList() {
            if (root == null) {
                return null;
            }

            root = convertToDoublyLinkedList(root);

            // Move to the leftmost node in the list
            while (root.getLeft() != null)
                root = root.getLeft();

            return root;
        }

        private Node1 convertToDoublyLinkedList(Node1 root) {

            if (root.getLeft() != null) {
                Node1 left = convertToDoublyLinkedList(root.getLeft());
                while (left.getRight() != null) {
                    left = left.getRight();
                }
                left.setRight(root);
                root.setLeft(left);
            }

            if (root.getRight() != null) {
                Node1 right = convertToDoublyLinkedList(root.getRight());
                while (right.getLeft() != null) {
                    right = right.getLeft();
                }
                right.setLeft(root);
                root.setRight(right);
            }

            return root;
        }

        /*
         * Create a sample tree
         *              1
         *      2               3
         * 4        5       6       7
         *
         */
        public void createSampleTree() {
            root = new Node1(1, new Node1(2, new Node1(4), new Node1(5)), new Node1(3, new Node1(6), new Node1(7)));
        }

        public static void main(String[] args) {
            BinaryTreeToDoubleLinkedList tree = new BinaryTreeToDoubleLinkedList();
            tree.createSampleTree();
            Node1 linkedList = tree.convertToDoublyLinkedList();
            printList(linkedList);
        }

        public static void printList(Node1 linkedList) {
            System.out.println("Output:");
            while(linkedList != null) {
                System.out.print(linkedList.getData() + " ");
                linkedList = linkedList.getRight();
            }
        }
    }

    class Node1 {

        private int data;
        private Node1 left;
        private Node1 right;

        public Node1(int data, Node1 left, Node1 right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node1(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node1 getLeft() {
            return left;
        }

        public void setLeft(Node1 left) {
            this.left = left;
        }

        public Node1 getRight() {
            return right;
        }

        public void setRight(Node1 right) {
            this.right = right;
        }
}
