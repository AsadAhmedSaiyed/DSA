public class Catalan {
    //recursion
    public int catalan(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        int ans = 0;
        for(int i=0;i<n;i++){
          ans += catalan(i)*catalan(n-i-1);
        }
        return ans;
    }
    //memo
    public int catalan2(int n, int dp[]){
        if(n == 0 || n == 1){
            return 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        int ans = 0;
        for(int i=0;i<n;i++){
          ans += catalan2(i,dp)*catalan2(n-i-1,dp);
        }
        return dp[n] = ans;
    }
    //tabulation
    public int catalan3(int n){
        int dp[] = new int[n+1];
        if(n == 0 || n == 1){
            return 1;
        }
        dp[0] = dp[1] = 1;
        for(int i=2;i<=n;i++){
            int ans = 0;
            for(int j=0;j<i;j++){
                ans += dp[j]*dp[i-j-1];
            }
            dp[i] = ans;
        }
        return dp[n];
    }
}
