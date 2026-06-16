public class LCSubstr {
    //recursion
    private int helper(String s1, String s2, int i, int j){
        if(i == 0 || j == 0 || s1.charAt(i-1) != s2.charAt(j-1)){
            return 0;
        }
        return 1 + helper(s1, s2, i-1, j-1);
    }
    public int longCommSubstr(String s1, String s2) {
        
        int res = 0;
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                res = Math.max(res, helper(s1, s2, i, j));
            }
        }
        return res;
    }
    //tabulation
       public int longCommSubstr2(String s1, String s2) {
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        int res = 0;
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
