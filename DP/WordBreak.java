import java.util.*;
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];
        HashSet<String> h = new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            h.add(wordDict.get(i));
        }
        dp[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j] && h.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
