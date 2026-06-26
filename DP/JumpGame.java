
public class JumpGame {

    //recursion
    //O(n^n)
    private int helper(int i, int nums[]) {
        if (i >= nums.length - 1) {
            return 0;
        }
        int minStep = nums.length;
        for (int j = 1; j <= nums[i]; j++) {
            minStep = Math.min(minStep, 1 + helper(i + j, nums));
        }
        return minStep;
    }

    public int jump(int[] nums) {
        return helper(0, nums);
    }
    //tab - O(n2)

    public int jump2(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = n;
            for (int j = 1; j <= nums[i] && i + j < n; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i + j]);
            }
        }
        return dp[0];
    }

    //greedy TC O(n) SC O(1)
     public int jump3(int[] nums) {
        int n = nums.length;
        int j =0 ;
        int currEnd = 0;
        int far = 0;
        for(int i=0;i<n-1;i++){
           far = Math.max(far, i + nums[i]);
           if(i == currEnd){
             j++;
             currEnd = far;
           }
        }
        return j;
    }
}
