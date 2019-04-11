package rough;

/**
 * Created by gsrinivasagam on 6/26/2018.
 */
public class LinkedList {
    Node1 head;

    // Add a new Node1 to the front of the linked list
    public void addToFront(int data) {
        Node1 n = new Node1(data);
        n.next = head;
        head = n;
    }

    // Print list elements
    public void printList() {
        Node1 tmp = head;
        while(tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    // Merge 2 sorted lists to form a single sorted list
    public void mergeList(LinkedList list) {

        if(list == null || list.head == null) {
            return;
        }
        if(head == null) {
            head = list.head;
            return;
        }

        Node1 tmp1 = head;
        Node1 tmp2 = list.head;
        if(tmp1.data < tmp2.data) {
            head = tmp1;
            tmp1 = tmp1.next;
        } else {
            head = tmp2;
            tmp2 = tmp2.next;
        }
        Node1 mergedNext = head;

        while(tmp1 != null && tmp2 != null) {
            if(tmp1.data < tmp2.data) {
                mergedNext.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                mergedNext.next = tmp2;
                tmp2 = tmp2.next;
            }
            mergedNext = mergedNext.next;
        }

        if(tmp1 != null) {
            mergedNext.next = tmp1;
        } else {
            mergedNext.next = tmp2;
        }
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addToFront(9);
        list1.addToFront(8);
        list1.addToFront(6);
        list1.addToFront(5);
        list1.addToFront(4);
        list1.addToFront(2);

        LinkedList list2 = new LinkedList();
        list2.addToFront(7);
        list2.addToFront(3);
        list2.addToFront(1);

        list1.mergeList(list2);
        System.out.println("Merged List:");
        list1.printList();
    }
}

class Node1 {
    int data;
    Node1 next;

    public Node1(int data) {
        this.data = data;
    }
}
