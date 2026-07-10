public class UniquePaths{
    private int helper(int i, int j, int m ,int n){
        if(i == (m-1) && j == (n-1)){
            return 1;
        }
        int path = 0;
        if(i+1 < m){
            path += helper(i+1,j,m,n);
        }
        if(j+1<n){
            path += helper(i,j+1, m,n); 
        }   
        return path;
    }
    public int uniquePaths(int m, int n) {
        return helper(0,0,m,n);
    }

    private int helper2(int i, int j, int m ,int n, int dp[][]){
        if(i == (m-1) && j == (n-1)){
            return 1;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int path = 0;
        if(i+1 < m){
            path += helper2(i+1,j,m,n,dp);
        }
        if(j+1<n){
            path += helper2(i,j+1, m,n, dp); 
        }   
        return dp[i][j] = path;
    }
    public int uniquePaths2(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        return helper2(0,0,m,n,dp);
    }
    public int uniquePaths3(int m, int n) {
        int dp[][] = new int[m][n];
        dp[m-1][n-1] = 1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i == m-1 && j == n-1){
                    continue;
                }
                int path = 0;
                if(i+1 < m){
                    path += dp[i+1][j];
                }
                if(j+1 < n){
                    path += dp[i][j+1];
                }
                dp[i][j] = path;
            }
        }
        return dp[0][0];
    }
    public int uniquePaths4(int m, int n) {
       long ans = 1;
        int N = m + n - 2;
        int R = Math.min(m-1,n-1);
        for(int i=0;i<R;i++){
            ans = ans*(N-i);
            ans = ans/(i+1);
        }
        return (int)ans;
    }
}