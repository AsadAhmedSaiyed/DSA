import java.util.*;
import java.util.Arrays;
class LongestWordInDict {
    public String longestWord(String[] words) {
        HashSet<String> s = new HashSet<>();
        Arrays.sort(words);
        String ans = "";
        for(String str : words){
            if(str.length() == 1 || s.contains(str.substring(0,str.length()-1))){
                s.add(str);
                if(str.length() > ans.length()){
                    ans = str;
                }
            }
        }
        return ans;
    }
}