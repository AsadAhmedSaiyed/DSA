public class LongestPalindromicSubstr{
    //TC SC - O(n2)
    public String longestPalindrome(String s) {
        int si = 0;
        int ei = 0;
        int max = 0;
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        for(int i=1;i<=n;i++){
            for(int start=0;start<=(n-i);start++){
                int end = start + i-1;
                boolean check = s.charAt(start) == s.charAt(end) ? true : false;
                if(i == 1){
                   dp[start][end] = true;
                }
                else if(i == 2){
                    dp[start][end] = check;
                }else{
                    
                    dp[start][end] = check && dp[start+1][end-1];
                }
                if(dp[start][end] == true && (end- start +1)>max){
                    si = start;
                    ei = end;
                    max = end - start+1;
                }
            }
        }
        return s.substring(si,ei+1);
    }
    public String longestPalindrome2(String s) {
        int si = 0;
        int ei = 0;
        String maxStr = s.substring(0,1);
        int n = s.length();
         for(int i=0;i<n-1;i++){
            String s1 = expand(i,i,s);
            String s2 = expand(i,i+1,s);
            if(s1.length() > maxStr.length()){
               maxStr = s1;
            }
            if(s2.length() > maxStr.length()){
               maxStr = s2;
            }
         }
        return maxStr;
    }
    private String expand(int i, int j,String s){
        int l = i;
        int r = j;
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }
}    