import java.util.HashMap;
import java.util.Set;


public class Map {
    public static void main(String[] args) {
        HashMap<String, Integer> m = new HashMap<>();
        m.put("India",100);
        m.put("China",150);
        m.put("US", 50);
        System.out.println(m);
        System.out.println(m.get("India"));
        System.out.println(m.containsKey("Iran"));
        System.out.println(m.remove("US"));
        System.out.println(m.size());
        System.out.println(m.isEmpty());

        //iterate
        //hm.entrySet() -> pairs set
        Set<String> keys = m.keySet();
        System.out.println(keys);
        for (String k : keys) {
            System.out.println("Key : " + k + ", Value : " + m.get(k));
        }
    }
}
