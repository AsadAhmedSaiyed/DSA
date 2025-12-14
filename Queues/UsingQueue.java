import java.util.LinkedList;
import java.util.Queue;

public class UsingQueue {

    // TLE
    public static class MyStack {
        Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {
            if (!q1.isEmpty()) {
                q1.add(x);
            } else {
                q2.add(x);
            }
        }

        public int pop() {
            if (empty()) {
                return -1;
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        return top;
                    }
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        return top;
                    }
                    q2.add(top);
                }
            }
            return top;
        }

        public int top() {
            if (empty()) {
                return -1;
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q2.add(top);
                }
            }
            return top;
        }

        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        class MyStack2 {
            Queue<Integer> q1;

            public MyStack2() {
                q1 = new LinkedList<>();
            }

            public void push(int x) {
                q1.add(x);
                for (int i = 1; i < q1.size(); i++) {
                    q1.add(q1.remove());
                }
            }

            public int pop() {
                return q1.remove();
            }

            public int top() {
                return q1.peek();
            }

            public boolean empty() {
                return q1.isEmpty();
            }
        }
    }

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        while (!s.empty()) {
            System.out.println(s.top());
            s.pop();
        }
    }
}
