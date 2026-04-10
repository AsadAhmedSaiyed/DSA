
import java.util.ArrayList;

public class CreateHeap {
    static class heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);
            int x = arr.size() - 1;

            while (x > 0) {
                int par = (x - 1) / 2;

                if (arr.get(x) < arr.get(par)) {
                    int temp = arr.get(x);
                    arr.set(x, arr.get(par));
                    arr.set(par, temp);
                    x = par;
                } else {
                    break;
                }
            }
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }

        public void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;
            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }
            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }
            if (minIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                heapify(minIdx);
            }

        }

        public int remove() {
            int data = arr.get(0);
            // swap
            int temp = arr.get(arr.size() - 1);
            arr.set(arr.size() - 1, data);
            arr.set(0, temp);

            // remove last
            arr.remove(arr.size() - 1);

            // heapify
            heapify(0);
            return data;

        }

        public int peek() {
            return arr.get(0);
        }
    }

    public static void main(String[] args) {
        heap  h = new heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        while(!h.isEmpty()){
            System.out.print(h.peek() + " ");
            h.remove();
        }
    }
}
