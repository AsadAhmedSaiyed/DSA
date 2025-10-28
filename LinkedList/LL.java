public class LL {

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
    public static int size;

    public void addFirst(int data){
      //O(1)
      //create
      Node newNode = new Node(data);
      size++;
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
      size++;
      if(head == null){
        head = tail = newNode;
        return;
      }

      tail.next = newNode;
      tail = newNode;
    }

    public void print(){
       
      Node temp = head;
      while(temp != null){
        System.out.print(temp.data + "->");
        temp = temp.next;
      }
      System.out.println("null");
    }

    public void addInMiddle(int idx,int data){
      if(idx == 0){
        addFirst(data);
        return;
      }
      Node temp = head;
      int i = 0;
      Node newNode = new Node(data);
      size++;
      while(i < idx-1){
       temp = temp.next;
       i++;
      }
      //i = idx-1
      newNode.next = temp.next;
      temp.next = newNode;

    }

    public int removeFirst(){

      if(size == 0){
        System.out.println("LL is empty");
        return Integer.MIN_VALUE;
      }else if(size == 1){
        size = 0;
        int val = head.data;
        head = tail = null;
        return val;
      }
      size--;
      int val = head.data;
      head = head.next;
      return val;

    }

    public int removeLast(){
      if(size == 0){
         System.out.println("LL is empty");
         return Integer.MIN_VALUE;
      }else if(size == 1){
         int val = head.data;
         head = tail = null;
         size= 0;
         return val;
      }
      //prev : i = size-2

      Node prev = head;
      for(int i=0;i<size-2;i++){
        prev = prev.next;
      }
      int val = prev.next.data;
      prev.next = null;
      tail = prev;
      size--;
      return val;
    }
    //iterative
    public int search(int key){
      int i=0;
      Node temp = head;
      while(temp != null){
        if(temp.data == key){
          return i;
        }
        temp = temp.next;
        i++;
      }
      return -1;
    }

    //recursive

    public int helper(Node head,int key){
      if(head == null){
        return -1;
      }
      if(head.data == key){
        return 0;
      }
      int idx = helper(head.next, key);
      if(idx == -1){
        return -1;
      }
      return idx+1;
    }

    public int recSearch(int key){
      return helper(head,key);
    }

    public static void main(String[] args) {
      LL ll = new LL();
      ll.print();
      //LL.head = new Node(1);
      //LL.head.next= new Node(2);
      ll.addFirst(2);
      ll.print();
      ll.addFirst(1);
      ll.print();
      ll.addLast(3);
      ll.print();
      ll.addLast(4);
      ll.print();
      ll.addInMiddle(2, 9);
      ll.print();
      ll.removeFirst();
      ll.print();
      ll.removeLast();
      ll.print();
      System.out.println(ll.recSearch(-9));
      System.out.println(size);
    }
}
