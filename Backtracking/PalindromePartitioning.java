public class PalindromePartitioning{
    private void helper(String s, List<String> curr, List<List<String>> ans, int idx, boolean dp[][]){
        if(idx == s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(dp[idx][i]){
                curr.add(s.substring(idx,i+1));
                helper(s, curr, ans, i+1, dp);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
     List<List<String>> ans = new ArrayList<>();
     List<String> curr = new ArrayList<>();
     boolean dp[][] = new boolean[s.length()][s.length()];
     for(int i=0;i<s.length();i++){
        dp[i][i] = true;
     }
     for(int l=2;l<=s.length();l++){
        for(int i=0;i<=s.length()-l;i++){
            int j=i+l-1;
            if(s.charAt(i) == s.charAt(j) && (l == 2 || dp[i+1][j-1])){
                dp[i][j] = true;
            }
        }
     }
     helper(s, curr, ans, 0, dp);
     return ans;  
    }
}