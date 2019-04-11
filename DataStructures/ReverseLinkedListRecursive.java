package Practice.LinkedList;

/**
 * Created by gsrinivasagam on 9/16/2018.
 */
public class ReverseLinkedListRecursive {
    private static Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
    class Node{

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

       public Node(int data){
            super();
            this.data  = data;
        }


    }

    public static void reverseLinkedListRecursive(Node curr){
        if(curr==null)
            return;
        if(curr.getNext()==null)
        {
            head = curr;
            return;
        }

        reverseLinkedListRecursive(curr.getNext());
        curr.getNext().setNext(curr);
        curr.setNext(null);
    }

    public static void reverseLinkedListRecursive(){
        reverseLinkedListRecursive(head);
    }

    public void printList(){
        Node temp = head;
        if(temp!=null){
            System.out.println(temp.getData()+"->");
            temp=temp.getNext();
        }
        System.out.println(temp.getData()+"X");
    }

    public void createLinkedList(int n){

        if(n<1){
            return;
        }
        int i=1;
        Node temp = null;
        while(i<=n){
            Node node = new Node(1);
            if(head==null){
                head=node;
                temp=head;
            }else{
                temp.setNext(node);
                temp=node;

            }
            i++;
        }
    }


    public static void main(String[] args) {
        ReverseLinkedListRecursive reverseLinkedListRecursive = new ReverseLinkedListRecursive();
        reverseLinkedListRecursive.createLinkedList(5);
        reverseLinkedListRecursive();
    }
}
