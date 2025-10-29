import java.util.Stack;

public class ReverseStack {
    private static void pushAtBottom(Stack<Integer> st,int x){
        if(st.isEmpty() == true){
            st.push(x);
            return;
        }
       int data = st.pop();
       pushAtBottom(st, x);
       st.push(data);
    }
    public static void reverseStack(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int data = st.pop();
        reverseStack(st);
        pushAtBottom(st,data);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
      s.push(1);
      s.push(2);
      s.push(3);

      while(!s.isEmpty()){
         System.out.println(s.peek());
         s.pop();
      }
      s.push(1);
      s.push(2);
      s.push(3);
      reverseStack(s);
      while(!s.isEmpty()){
         System.out.println(s.peek());
         s.pop();
      }
    }
}
