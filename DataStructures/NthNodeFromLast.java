package Practice.LinkedList;

public class NthNodeFromLast
{
    private class ListNode
    {
        int value;
        ListNode next;

        ListNode(int value)
        {
            this.value = value;
        }
    }

    ListNode head;
    ListNode tail;

    public NthNodeFromLast()
    {

    }

    // appends node at the end of the list
    private void appendNode(int value)
    {
        if (head == null)
        {
            head = new ListNode(value);
            tail = head;
            return;
        }

        ListNode n = new ListNode(value);
        tail.next = n;
        tail = n;
    }

    public void createLinkedList()
    {
        for (int i = 1; i <= 7; i++)
        {
            appendNode(i);
        }
    }


    public void printList()
    {
        ListNode temp = head;

        while (temp != null)
        {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }



    public int findNthFromEnd(int n)
    {
        ListNode node1 = head, node2 =head;

        int count =1;

        while(node1!=null){
            if(count!=n+1){
                count++;
                node1=node1.next;
            }
        }

        if(count==n+1){
            while (node1!=null){
                node1=node1.next;
                node2=node2.next;
            }
            return node2.value;
        }
        else {
            return -1;
        }
    }


    public static void main(String[] args)
    {
        NthNodeFromLast solution = new NthNodeFromLast();

        solution.createLinkedList();

        solution.printList();

        System.out.println("\n\nrequired 'n'th node from the last is: " + solution.findNthFromEnd(2));
    }
}