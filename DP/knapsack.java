public class knapsack {
    //recursion
    private int helper(int W, int val[], int wt[], int n){
        if(n == 0 || W == 0 ){
            return 0;
        }
        if(wt[n-1] <= W){
            int ans1 = val[n-1] + helper(W-wt[n-1], val, wt, n-1);
            int ans2 = helper(W, val, wt, n-1);
            return Math.max(ans1, ans2);
        }else{
            return helper(W, val, wt, n-1);
        }
    }
    //memoization
    private int helper(int W, int val[], int wt[], int n, int dp[][]){
        if(n == 0 || W == 0 ){
            return 0;
        }
        if(dp[n][W] != 0){
            return dp[n][W];
        }
        if(wt[n-1] <= W){
            int ans1 = val[n-1] + helper(W-wt[n-1], val, wt, n-1,dp);
            int ans2 = helper(W, val, wt, n-1, dp);
            return dp[n][W] =  Math.max(ans1, ans2);
        }else{
            return dp[n][W] = helper(W, val, wt, n-1,dp);
        }
    }
    public int knapsack(int W, int val[], int wt[]) {
        int dp[][] = new int[val.length+1][W+1];
        return helper(W, val, wt, val.length,dp);
    }
    //tabulation
    public int knapsack2(int W, int val[], int wt[]) {
        int dp[][] = new int[val.length+1][W+1];
        for(int i=1;i<=val.length;i++){
            for(int j=1;j<=W;j++){
                int v = val[i-1];
                int w = wt[i-1];
                if(w <= j){
                    dp[i][j] = Math.max(v + dp[i-1][j-w], dp[i-1][j]);
                }else{
                    dp[i][j] =  dp[i-1][j];
                }
            }
        }
        return dp[val.length][W];
    }
}
