public class DoubleLL {

    public class Node{
        int data;
        Node next;
        @SuppressWarnings("unused")
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int removeFirst(){
        if(head == null){
            return Integer.MIN_VALUE;
        }
        int val = head.data;
        size--;
        if(size == 1){
         head = tail = null;
         return val;
        }
        head= head.next;
        head.prev = null;
        return val;
    }

    public int removeLast(){
        if(tail == null){
            return Integer.MIN_VALUE;
        }
        int val = head.data;
        size--;
        if(size == 1){
         head = tail = null;
         return val;
        }
        tail = tail.prev;
        tail.next = null;
        return val;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(tail == null){
            head = tail = newNode;
            return;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next;
        while(curr !=null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print();
        System.out.println(size);
        System.out.println(dll.removeFirst());
        dll.print();
        System.out.println(size);
        dll.addLast(5);
        System.out.println(size);
        dll.print();
        dll.removeLast();
        dll.print();
        System.out.println(size);
        dll.reverse();
        dll.print();
    }
}
