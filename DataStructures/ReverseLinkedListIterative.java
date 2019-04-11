package Practice.LinkedList;

/**
 * Created by gsrinivasagam on 9/16/2018.
 */
public class ReverseLinkedListIterative{
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

    public static void reverseLinkedListIterative(Node head){
        Node prev=null;
        Node curr=null;
        Node nxt = head;
        if(nxt!=null){
            curr=nxt;
            nxt=curr.getNext();
            curr.setNext(prev);
            prev=curr;
        }
    }

    public static void reverseLinkedListIterative(){
        reverseLinkedListIterative(head);
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
        ReverseLinkedListIterative  reverseLinkedListIterative  = new ReverseLinkedListIterative();
        reverseLinkedListIterative.createLinkedList(5);
        reverseLinkedListIterative();
    }
}
