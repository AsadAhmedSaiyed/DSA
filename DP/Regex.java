public class Regex{
    private boolean helper(String s, String p, int i, int j){
        if(i == s.length() && j == p.length()){
            return true;
        }

        if(j >= p.length()){
            return false;
        }
     
        boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            if(firstMatch){
                return helper(s, p, i, j+2) || helper(s, p, i+1, j);
            }else{
              return helper(s, p, i, j+2);
            }
        }else{
           if(firstMatch){
               return helper(s, p, i+1, j+1);
           }else{
             return false;
           }   
        }
    }
    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }
}