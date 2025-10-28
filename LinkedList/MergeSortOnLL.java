
public class MergeSortOnLL {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void print() {

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void addFirst(int data) {
        // O(1)
        // create
        Node newNode = new Node(data);
        // ll is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // newnode next = prev head
        newNode.next = head;

        // new head

        head = newNode;

    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;
    }

    private Node merge(Node newLeft,Node newRight){
       Node mergNode = new Node(Integer.MIN_VALUE);
       Node temp = mergNode;
       while(newLeft != null && newRight != null){
         if(newLeft.data <= newRight.data){
            temp.next = newLeft;
            newLeft = newLeft.next;

         }else{
            temp.next = newRight;
            newRight = newRight.next;

         }
         temp = temp.next;
       }
       while(newLeft != null){
           temp.next = newLeft;
            newLeft = newLeft.next;
            temp = temp.next;
       }
       while(newRight != null){
           temp.next = newRight;
            newRight = newRight.next;
            temp = temp.next;
       }
       return mergNode.next;
    }

    //TC - O(nlogn) SC - O(logn)
    public Node mergeSort(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        //find mid
        Node mid = getMid(head);
        //left and right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        //merge

        return merge(newLeft,newRight);
    }

    

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
      MergeSortOnLL ll = new MergeSortOnLL();
      ll.addFirst(5);
      ll.addFirst(3);
      ll.addFirst(2);
      ll.addFirst(1);

      ll.print();
      //ll.head = ll.mergeSort(ll.head);
      //ll.print();
     
      ll.print();
    }
}
