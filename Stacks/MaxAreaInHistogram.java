import java.util.Stack;

public class MaxAreaInHistogram {
    // BF
    // multiple traversal
    public static int largestRectangleArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        int nextSmaller[] = new int[heights.length];
        int prevSmaller[] = new int[heights.length];
        Stack<Integer> n = new Stack<>();
        Stack<Integer> p = new Stack<>();
        for (int j = heights.length - 1; j >= 0; j--) {
            int next;
            while (!n.isEmpty() && heights[n.peek()] >= heights[j]) {
                n.pop();
            }
            if (n.isEmpty()) {
                next = heights.length;
            } else {
                next = n.peek();
            }
            nextSmaller[j] = next;
            n.push(j);
        }
        for (int k = 0; k < heights.length; k++) {
            int prev;
            while (!p.isEmpty() && heights[p.peek()] >= heights[k]) {
                p.pop();
            }
            if (p.isEmpty()) {
                prev = -1;
            } else {
                prev = p.peek();
            }
            prevSmaller[k] = prev;
            p.push(k);
        }

        for (int i = 0; i < heights.length; i++) {
            int NSE = nextSmaller[i];
            int PSE = prevSmaller[i];
            int area = heights[i] * (NSE - PSE - 1);
            max = Math.max(area, max);
        }
        return max;
    }

    // optimized
    public static int largestArea(int[] heights) {
        int max = 0;
        Stack<Integer> s = new Stack<>();
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] > heights[i]) {
                int h = heights[s.pop()];
                int w = s.isEmpty() ? i : i - s.peek() - 1;
                max = Math.max(max, h * w);
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            int idx = s.pop();
            int h = heights[idx];
            int w = s.isEmpty() ? n : n - s.peek() - 1;
            max = Math.max(max, h * w);

        }
        return max;
    }

    public static void main(String[] args) {

    }
}
