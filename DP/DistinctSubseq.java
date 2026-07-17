public class DistinctSubseq{
      public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int dp[] = new int[n+1];
        dp[n] = 1;
        for(int i=m-1;i>=0;i--){
            for(int j=0;j<n;j++){
                if(s.charAt(i) == t.charAt(j)){
                    dp[j] = dp[j] + dp[j+1];
                }
            }
        }
        return dp[0];
    }
}