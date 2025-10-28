public class RemoveCycle{
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

    public static void removeCycle(){
        //detect cycle
        Node fast = head;
        Node slow = head;
        boolean isCycle = false;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                isCycle = true;
                break;
            }
        }


        if(!isCycle){
            return;
        }

        //finding ending point
        slow = head;
        Node prev = null;
        while(slow != fast){
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }
        //removing cycle
        prev.next = null;

    }

    public static void main(String[] args) {
    
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        //1->2->3->2
    }
}