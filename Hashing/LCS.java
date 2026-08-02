import java.util.HashSet;

public class LCS {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for(int n : nums){
            s.add(n);
        }
        int max = 0;
        for(int n : s){
            if(!s.contains(n-1)){
               int count = 1;
               while(s.contains(n+1)){
                 count++;
                 n++;
               }
               max = Math.max(max,count);
            }
        }
        return max;
    }
}
