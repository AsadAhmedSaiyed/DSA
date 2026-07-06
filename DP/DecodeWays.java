public class DecodeWays{
    //TC - O(2^n)
    private int helper(int i, String s){
        if(i > s.length()-1){
            return 1;
        }
        if(s.charAt(i) == '0'){
            return 0;
        }
        int c1 = helper(i+1,s);
        if(i+1 < s.length()){
            int d1 = s.charAt(i) - '0';
            int d2 = s.charAt(i+1) - '0';
           int num = d1*10 + d2;
           if(num >= 10 && num <= 26){
             int c2 = helper(i+2, s);
             return c1+c2;
            }
        }
        return c1;
    }
    public int numDecodings(String s) {
        return helper(0,s);
    }
    //memo - TC O(N)
    private int helper2(int i, String s, int dp[]){
        if(i > s.length()-1){
            return 1;
        }
        if(s.charAt(i) == '0'){
            return 0;
        }
        if(dp[i] != 0){
            return dp[i];
        }
        int c1 = helper2(i+1,s,dp);
        if(i+1 < s.length()){
            int d1 = s.charAt(i) - '0';
            int d2 = s.charAt(i+1) - '0';
           int num = d1*10 + d2;
           if(num >= 10 && num <= 26){
             int c2 = helper2(i+2, s,dp);
             return dp[i] = c1+c2;
            }
        }
        return dp[i] = c1;
    }
    public int numDecodings2(String s) {
        int dp[] = new int[s.length()+1];
        return helper2(0,s,dp);
    }
    //tab
    public int numDecodings3(String s) {
        int n = s.length();
        int dp[] = new int[n+1];
        dp[n] = 1;
        for(int i=n-1;i>=0;i--){
           if(s.charAt(i) == '0'){
             dp[i] = 0;
           }else{
              dp[i] = dp[i+1];
              if(i+1 < n){
                  int d1 = s.charAt(i) - '0';
                  int d2 = s.charAt(i+1) - '0';
                  int num = d1*10 + d2;
                  if(num >= 10 && num <= 26){
                    dp[i] += dp[i+2];
                  } 
              }
           }
        }
        return dp[0];
    }
    //space otpmized
    public int numDecodings4(String s) {
        int n = s.length();
        int next2 = 1;
        int next1 = 1;
        for(int i=n-1;i>=0;i--){
            int curr;
           if(s.charAt(i) == '0'){
             curr = 0;
           }else{
              curr = next1;
              if(i+1 < n){
                  int d1 = s.charAt(i) - '0';
                  int d2 = s.charAt(i+1) - '0';
                  int num = d1*10 + d2;
                  if(num >= 10 && num <= 26){
                    curr += next2;
                  } 
              }
           }
           next2 = next1;
           next1 = curr;
        }
        return next1;
    }
}