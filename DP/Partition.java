public class Partition {
    public int minDifference(int nums[]) {
          int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
           sum += nums[i];
        }
        int w = sum/2;
        int dp[][] = new int[n+1][w+1];
        //el
        for(int i=1;i<=n;i++){
            //sum
            for(int j=1;j<=w;j++){
                //check valid
                if(nums[i-1]<= j){
                    dp[i][j] = Math.max(nums[i-1] + dp[i-1][j-nums[i-1]], dp[i-1][j]);
                }else{
                     dp[i][j] =  dp[i-1][j];
                }
            }
        } 
        int sum1 = dp[n][w];
        int sum2 = sum- sum1;
        return  Math.abs(sum1-sum2);
        
    }
}
