class LCS{
    //recursion
    private int helper(String text1, String text2, int i, int j){
        if(i < 0 || j < 0){
            return 0;
        }
        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + helper(text1, text2, i-1, j-1);
        }else{
            int a = helper(text1, text2, i-1, j);
            int b = helper(text1, text2, i, j-1);
            return Math.max(a,b);
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
       return helper(text1, text2, text1.length()-1, text2.length()-1);
    }
    //memo
    private int helper2(String text1, String text2, int i, int j, int dp[][]){
        if(i < 0 || j < 0){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i][j] = 1 + helper2(text1, text2, i-1, j-1,dp);
        }else{
            int a = helper2(text1, text2, i-1, j, dp);
            int b = helper2(text1, text2, i, j-1, dp);
            return dp[i][j] = Math.max(a,b);
        }
    }
    public int longestCommonSubsequence2(String text1, String text2) {
       int dp[][] = new int[text1.length()+1][text2.length()+1]; 
       return helper2(text1, text2, text1.length()-1, text2.length()-1,dp);
    }
    //tabulation
      public int longestCommonSubsequence3(String text1, String text2) {
       int dp[][] = new int[text1.length()+1][text2.length()+1]; 
       for(int i=1;i<=text1.length();i++){
         for(int j=1;j<=text2.length();j++){
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                dp[i][j] = 1 + dp[i-1][j-1];
            }else{
                int a = dp[i-1][j];
                int b = dp[i][j-1];
                dp[i][j] = Math.max(a,b);
            }
         }
       }
       return dp[text1.length()][text2.length()];
    }
}