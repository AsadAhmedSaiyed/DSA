import java.util.*;

public class Stacks {

    public static class MyQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        // O(n)
        public void add(int x) {
            while (!s1.isEmpty()) {
                int temp = s1.pop();
                s2.push(temp);
            }
            s1.push(x);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // 1
        public int remove() {
            if (!s1.isEmpty()) {
                return s1.pop();
            } else {
                return -1;
            }
        }

        // 1
        public int peek() {
            if (!s1.isEmpty()) {
                return s1.peek();
            } else {
                return -1;
            }
        }

        public boolean isEmpty() {
            return s1.isEmpty();
        }

        public static class MyQueue2 {
            Stack<Integer> s1;
            Stack<Integer> s2;

            public MyQueue2() {
                s1 = new Stack<>();
                s2 = new Stack<>();
            }

            public void push(int x) {
                s1.push(x);
            }

            public int pop() {
                if (s2.isEmpty()) {
                    transfer();
                }
                return s2.pop();
            }

            public int peek() {
                if (s2.isEmpty()) {
                    transfer();
                }
                return s2.peek();
            }

            public boolean empty() {
                return s1.isEmpty() && s2.isEmpty();
            }

            private void transfer() {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.add(1);
        q.add(2);
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
