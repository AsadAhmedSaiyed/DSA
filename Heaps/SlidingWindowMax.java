import java.util.*;
class Solution {
    private static class Num implements Comparable<Num>{
        int val;
        int idx;
        public Num(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
        @Override
        public int compareTo(Num n2){
            return n2.val-this.val;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[] = new int[nums.length-k+1];
        PriorityQueue<Num> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(new Num(nums[i],i));
        }
        ans[0] = pq.peek().val;
        for(int i=k;i<nums.length;i++){
            while(pq.size() > 0 && pq.peek().idx <= (i-k)){
                pq.remove();
            }
            pq.add(new Num(nums[i],i));
            ans[i-k+1] = pq.peek().val;
        }

        return ans;

    }
}
