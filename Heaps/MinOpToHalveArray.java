import java.util.*;

//store el in maxheap
//find total and half
//remove largest and reduced it by halve and add in pq
//sutract half val of largest from total 
//repeat until total > half 

public class MinOpToHalveArray {

    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        double total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            pq.add((double) nums[i]);
        }
        double half = total / 2;
        int count = 0;
        while (total > half) {
            double num = pq.remove();
            double halfNum = num / 2;
            pq.add(halfNum);
            total -= halfNum;
            count++;
        }
        return count;
    }
}
