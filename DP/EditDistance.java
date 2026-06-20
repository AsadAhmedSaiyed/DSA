public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];
        for(int j=0;j<=m;j++){
            dp[0][j] = j;
        }
        for(int j=0;j<=n;j++){
            dp[j][0] = j;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
               if(word1.charAt(i-1) == word2.charAt(j-1)){
                  dp[i][j] = dp[i-1][j-1];
               }else{
                 int a = 1 + dp[i][j-1];
                 int b = 1 + dp[i-1][j-1];
                 int c = 1 + dp[i-1][j];
                 dp[i][j] = Math.min(a, Math.min(b, c));
               }
            }
        }
        return dp[n][m];
    }
}
