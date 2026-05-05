import java.util.*;
import java.util.Map;
public class UniqueNumOccur {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            m.put(arr[i], m.getOrDefault(arr[i],0)+1);
        } 
        HashSet<Integer> s = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry : m.entrySet()){
            s.add(entry.getValue());
        }
        
        return m.size() == s.size();
    }
}

