
import java.util.ArrayDeque;
import java.util.Queue;


public class UsingJCF {
    public static void main(String[] args) {
        //Queue<Integer>  q = new LinkedList<>();
        //O(n) for all op
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
