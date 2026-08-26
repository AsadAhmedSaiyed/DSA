import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
   private HashMap<String, TreeMap<Integer, String>> m;
    public TimeMap() {
        m = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(m.containsKey(key)){
          m.get(key).put(timestamp,value);
        }else{
            TreeMap<Integer, String> t = new TreeMap<>();
            t.put(timestamp,value);
            m.put(key,t);
        }
    }
    
    public String get(String key, int timestamp) {
        if(m.containsKey(key)){
            Map.Entry<Integer, String> entry = m.get(key).floorEntry(timestamp);
            if(entry != null)
               return entry.getValue();
        }
        return "";
    }   
}
