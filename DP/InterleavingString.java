class InterleavingString {
    private boolean helper(String s1, String s2, String s3, int i, int j){
        if(i == s1.length() && j == s2.length()){
            return true;
        }
        if(i <s1.length() && j < s2.length() && s1.charAt(i) == s3.charAt(i+j) && s2.charAt(j) == s3.charAt(i+j)){
           return helper(s1,s2,s3,i+1,j) || helper(s1,s2,s3, i,j+1);
        }
        else if(i <s1.length() && s1.charAt(i) == s3.charAt(i+j)){
            return helper(s1,s2,s3,i+1,j);
        }
        else if(j < s2.length() && s2.charAt(j) == s3.charAt(i+j)){
            return helper(s1,s2,s3,i,j+1);
        }else{
            return false;
        }
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        return helper(s1,s2,s3, 0,0);
    }

    private boolean helper2(String s1, String s2, String s3, int i, int j, Boolean dp[][]){
        if(i == s1.length() && j == s2.length()){
            return true;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(i <s1.length() && j < s2.length() && s1.charAt(i) == s3.charAt(i+j) && s2.charAt(j) == s3.charAt(i+j)){
           return dp[i][j] = helper2(s1,s2,s3,i+1,j, dp) || helper2(s1,s2,s3, i,j+1, dp);
        }
        else if(i <s1.length() && s1.charAt(i) == s3.charAt(i+j)){
            return dp[i][j] = helper2(s1,s2,s3,i+1,j, dp);
        }
        else if(j < s2.length() && s2.charAt(j) == s3.charAt(i+j)){
            return dp[i][j] = helper2(s1,s2,s3,i,j+1, dp);
        }else{
            return false;
        }
    }
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        Boolean dp[][] = new Boolean[m+1][n+1];
        return helper2(s1,s2,s3, 0,0, dp);
    }
    public boolean isInterleave3(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        boolean dp[] = new boolean[n+1];
        dp[n] = true;
        for(int i=m;i>=0;i--){
            for(int j=n;j>=0;j--){
                if(i == m && j == n){
                    continue;
                }
                if(i <m && j < n && s1.charAt(i) == s3.charAt(i+j) && s2.charAt(j) == s3.charAt(i+j)){
                    dp[j] = dp[j] || dp[j+1];
                }
                else if(i <m && s1.charAt(i) == s3.charAt(i+j)){
                    dp[j] = dp[j];
                }
                else if(j < n && s2.charAt(j) == s3.charAt(i+j)){
                    dp[j] = dp[j+1];
                }else{
                    dp[j] = false;
                }
            }
        }
        return dp[0];
    }
}