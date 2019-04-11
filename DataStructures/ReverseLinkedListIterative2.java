package rough;

/**
 * Created by gsrinivasagam on 6/26/2018.
 */
public class ReverseLinkedListIterative {

    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void reverseList() {

        Node prev = null;
        Node curr = null;
        Node nxt = head;

        while(nxt != null) {
            curr = nxt;
            nxt = nxt.getNext();
            curr.setNext(prev);
            prev = curr;
        }
        head = curr;
    }

    /*
     * ******************************************************
     * Following methods are for testing reverseList
     * ******************************************************
     */
    public static void main(String[] args) {

        ReverseLinkedListIterative list = new ReverseLinkedListIterative();
        list.createTestList(10);
        list.printlist();
        list.reverseList();
        list.printlist();
    }

    /*
     * Create a test list having n nodes from 1 to n
     */
    public void createTestList(int n) {

        if(n < 1)
            return;

        int i = 1;
        Node temp = null;
        while(i <= n) {
            Node node = new Node(i);
            if(head == null) {
                head = node;
                temp = head;
            } else {
                temp.setNext(node);
                temp = node;
            }
            i++;
        }
    }

    /*
     * Print the list
     */
    public void printlist() {

        Node temp = head;
        while(temp != null) {
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();
        }
        System.out.println("X");
    }

    /**
     * Defines a linked list node class
     * @author Saurabh
     *
     */
    class Node {

        private int data;
        private Node next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(int data) {
            super();
            this.data = data;
        }

    }
}
