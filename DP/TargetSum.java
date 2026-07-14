public class TargetSum {
    
    public int findTargetSumWays(int[] nums, int target) {
        
        int total = 0;
        for(int i=0;i<nums.length;i++){
           total += nums[i];
        }
        int dp[][] = new int[nums.length+1][2*total+1];
        int offset = total;
        return helper(nums, 0,0,target, dp,offset);
    }

    private int helper(int nums[], int sum, int i, int target,int dp[][] , int offset){
        if(i == nums.length && sum == target){
            return 1;
        }
        if(i == nums.length && sum != target){
            return 0;
        }
        if(dp[i][sum + offset] != 0){
            return dp[i][sum + offset];
        }
        return dp[i][sum + offset] = helper(nums, sum + nums[i], i+1, target,dp,offset) + helper(nums, sum-nums[i], i+1, target,dp,offset);
    }
     public int findTargetSumWays2(int[] nums, int target) {
        int total = 0;
        for(int i=0;i<nums.length;i++){
            total += nums[i];
        }
        int sum = (total+target)/2;
        if(Math.abs(target) > total || (total + target)%2 != 0){
            return 0;
        }
        
        int dp[] = new int[sum+1];
        dp[0] = 1;
        for(int num : nums){
            for(int j = sum; j>=num;j--){
                dp[j] += dp[j-num];
            }
        }
        return dp[sum];
    }
}
