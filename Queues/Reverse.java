import java.util.Queue;
import java.util.Stack;

public class Reverse {
    public void reverseQueue(Queue<Integer> q) {
        // code here
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }
    public static void main(String[] args) {
        
    }
}
