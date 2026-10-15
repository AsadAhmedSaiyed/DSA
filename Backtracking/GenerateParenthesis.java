import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    private void helper(List<String> ans, StringBuilder s, int open, int close, int n){
       if(s.length() == 2*n){
         ans.add(s.toString());
         return;
       }
       if(open < n){
          s.append('(');
          helper(ans, s, open+1, close, n);
          s.deleteCharAt(s.length()-1);
       }

       if(close < open){
          s.append(')');
          helper(ans, s, open, close+1, n);
          s.deleteCharAt(s.length()-1);
       }
    }
    public List<String> generateParenthesis(int n) {
        StringBuilder s = new StringBuilder("");
        List<String> ans = new ArrayList<>();
        helper(ans, s, 0, 0, n);
        return ans;
    }
}
