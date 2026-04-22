import java.util.Collections;
import java.util.PriorityQueue;

//heap approach
//TC - O(NlogN) SC - O(N)

//optimized approach remaining
//using quick select algorithm 
//TC - O(N) SC - O(1)

class KthLargestInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        int i=1;
        while(i < k){
            pq.remove();
            i++;
        }
        return pq.peek();
    }
}