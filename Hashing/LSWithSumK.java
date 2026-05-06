import java.util.*;
public class LSWithSumK {
   public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int sum =0;
        int ans = 0;
        m.put(0,1);
        for(int j=0;j<nums.length;j++){
            sum += nums[j];
            if(m.containsKey(sum-k)){
               ans += m.get(sum-k);
            }
            m.put(sum, m.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
