public class ReverseLL {
     public static class Node{
      int data;
      Node next;

      public Node(int data){
        this.data = data;
        this.next = null; 
      }
    }

    public static Node head;
    public static Node tail;

    public void print(){
       
      Node temp = head;
      while(temp != null){
        System.out.print(temp.data + "->");
        temp = temp.next;
      }
      System.out.println("null");
    }

    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void addFirst(int data){
      //O(1)
      //create
      Node newNode = new Node(data);
      //ll is empty
      if(head == null){
        head = tail = newNode;
        return;
      }

      //newnode next = prev head
      newNode.next = head;

      //new head

      head = newNode;

    }

    public void addLast(int data){
      Node newNode = new Node(data);
      if(head == null){
        head = tail = newNode;
        return;
      }

      tail.next = newNode;
      tail = newNode;
    }

    public static void main(String[] args) {
        ReverseLL ll = new ReverseLL();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();
        ll.reverse();
        ll.print();   
         
    }
}
