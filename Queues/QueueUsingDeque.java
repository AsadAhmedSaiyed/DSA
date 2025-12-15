
import java.util.Deque;
import java.util.LinkedList;


public class QueueUsingDeque {
    public static class MyQueue{
       Deque<Integer> s;

        public MyQueue() {
            s = new LinkedList<>();
        }
        public void add(int x){
          s.addLast(x);
        }
        public int remove(){
            return s.removeFirst();
        }
        public int peek(){
            return s.getFirst();
        }
       
    }
    public static void main(String[] args) {
        MyQueue st = new MyQueue();
        st.add(1);
        st.add(2);
        st.add(3);
        System.out.println(st.remove());
        System.out.println(st.remove());
        System.out.println(st.remove());
    }
}