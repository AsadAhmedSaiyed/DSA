import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> m = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String s = strs[i];
            int count[] = new int[26];
            for(int j=0;j<s.length();j++){
                count[s.charAt(j)-'a']++;
            }
            String k = Arrays.toString(count);
            List<String> arr = m.getOrDefault(k,new ArrayList<>());
            arr.add(s);
            m.put(k,arr);
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : m.entrySet()){
           ans.add(entry.getValue()); 
        }
        return ans;
    }   
}
