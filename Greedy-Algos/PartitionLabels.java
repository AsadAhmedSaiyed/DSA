import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> h = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            h.put(s.charAt(i), i);
        }
        int start = 0;
        int far = 0;
        for(int i=0;i<s.length();i++){
           far = Math.max(far, h.get(s.charAt(i)));
           if(i == far){
             ans.add(far-start+1);
             start = far+1;
           }  
        }
        return ans;
    }
}
