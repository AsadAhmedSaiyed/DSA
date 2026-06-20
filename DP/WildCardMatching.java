class WildCardMatching{
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int j=1;j<=m;j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*'){
                   dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
    //space optimized DP 
    public boolean isMatch2(String s, String p) {
            int n = s.length();
            int m = p.length();
            if (m == 0 && n > 0) {
              return false;
            }
            boolean prev[] = new boolean[m+1];
            boolean curr[] = new boolean[m+1];
            prev[0] = true;
            for(int j=1;j<=m;j++){
                if(p.charAt(j-1) == '*'){
                    prev[j] = prev[j-1];
                }
            }
            for(int i=1;i<=n;i++){
                curr = new boolean[m+1];
                for(int j=1;j<=m;j++){
                    if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                        curr[j] = prev[j-1];
                    }
                    else if(p.charAt(j-1) == '*'){
                        curr[j] = curr[j-1] || prev[j];
                    }else{
                        curr[j] = false;
                    }
                }
                boolean temp[] = prev; 
                prev = curr;
                curr = temp;
            }
          return prev[m];
    }
}