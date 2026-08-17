import java.util.Arrays;
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
    public int lengthOfLongestSubstring2(String s) {
        int lastSeen[] = new int[128];
        Arrays.fill(lastSeen,-1);
        int max = 0;
        int l = 0;
        for(int i=0;i<s.length();i++){
           int prevIdx = lastSeen[s.charAt(i)];
           if((prevIdx >= l && prevIdx <= i)){
              l = prevIdx + 1;
           }
           lastSeen[s.charAt(i)] = i;
           max = Math.max(max, i-l+1);
        }
        return max;
    }
}