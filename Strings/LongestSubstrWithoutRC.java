import java.util.HashSet;

public class LongestSubstrWithoutRC{
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int l = 0;
        for(int i=0;i<s.length();i++){
           while(set.contains(s.charAt(i))){
             set.remove(s.charAt(l));
             l++;
           }
           set.add(s.charAt(i));
           max = Math.max(max, i-l+1);
        }
        return max;
    }
}