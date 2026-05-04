import java.util.*;
public class LinkedHM {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> m = new LinkedHashMap<>();
        m.put("india", 100);
        m.put("china", 150);
        m.put("us",50);
        m.put("indonesia", 125);

        System.out.println(m);

        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("india", 100);
        tm.put("china", 150);
        tm.put("us",50);
        tm.put("indonesia",125);

        System.out.println(tm);

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("india", 100);
        hm.put("china", 150);
        hm.put("us",50);
        hm.put("indonesia", 125);

        System.out.print(hm);
    }
}
