import java.util.*;

public class LongestSubarrayWithSumZero {

    public static int maxLength(int arr[]) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int sum = 0;
        int length = 0;

        m.put(0, -1);

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if(m.containsKey(sum)) {
                length = Math.max(length, i - m.get(sum));
            } else {
                m.put(sum, i);
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, -2, 1, -1};

        int result = maxLength(arr);
        System.out.println(result);
    }
}