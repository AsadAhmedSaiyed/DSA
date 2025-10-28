public class DeleteNthfromEnd {
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

    public void delete(int n){
        int sz=0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }
        if(n ==  sz){
          head = head.next;
          return;
        }
        Node curr = head;
        int j=0;
        while(j < sz-n-1){
            curr = curr.next;
            j++;
        }
        curr.next = curr.next.next;
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
        DeleteNthfromEnd ll = new DeleteNthfromEnd();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();
        ll.delete(2);
        ll.print();
    }
}
