public class Array{
    static class Queue{
        int arr[];
        int size;
        int rear;
        Queue(int n){
           arr = new int[n];
           size = n;
           rear = -1;
        }
        public boolean isEmpty(){
            return rear == -1;
        }
        //add
        public void add(int data){
            if(rear == size-1){
               System.out.println("queue is full");
               return;
            }
            rear++;
            arr[rear] = data;
        }
        //remove
        public int remove(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            int front = arr[0];
            for(int i=0;i<rear;i++){
               arr[i] = arr[i+1];
            }
            rear--;
            return front;
        }
        //peek
        public int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }

            return arr[0];
        }
    }
    static class Circular{
        int arr[];
        int size;
        int rear;
        int front;
        Circular(int n){
           arr = new int[n];
           size = n;
           rear = -1;
           front = -1;
        }
        public boolean isEmpty(){
            return rear == -1 && front == -1;
        }
        public boolean isFull(){
            return (rear+1)%size == front;
        }
        //add
        public void add(int data){
            if(isFull()){
               System.out.println("queue is full");
               return;
            }
            if(front == -1){
                front = 0;
            }
            rear = (rear+1)%size;
            arr[rear] = data;
        }
        //remove
        public int remove(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            int res = arr[0];
            if(rear == front){
                rear = front = -1;
            }else{
                front  = (front+1)%size;
            }
            return res;
        }
        //peek
        public int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }

            return arr[front];
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.print( q.peek()+ " ");
            q.remove();
        }
        Circular c = new Circular(5);
        c.add(1);
        c.add(2);
        c.add(3);
        while(!c.isEmpty()){
            System.out.print( c.peek()+ " ");
            c.remove();
        }
    }
}