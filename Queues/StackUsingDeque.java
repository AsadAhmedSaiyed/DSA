
import java.util.Deque;
import java.util.LinkedList;


public class StackUsingDeque {
    public static class MyStack{
       Deque<Integer> s;

        public MyStack() {
            s = new LinkedList<>();
        }
        public void push(int x){
          s.addLast(x);
        }
        public int pop(){
            return s.removeLast();
        }
        public int peek(){
            return s.getLast();
        }
       
    }
    public static void main(String[] args) {
        MyStack st = new MyStack();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
    }
}
