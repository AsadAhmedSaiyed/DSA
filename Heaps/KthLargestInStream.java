import java.util.*;
//maintain only k largest el in min heap
//on add remove extra el from heap

//remaining -> Path With Minimum Effort
class KthLargestInStream {
    PriorityQueue<Integer> pq;
    int k;
    int nums[];
    public KthLargestInStream(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.remove();
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size()>k){
            pq.remove();
        }
        return pq.peek();
    }
}
