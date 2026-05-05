import java.util.HashMap;

public class Tickets {
    public static void main(String[] args) {
        HashMap<String, String> t = new HashMap<>();
        t.put("c","b");
        t.put("m","d");
        t.put("g","c");
        t.put("d","g");
        HashMap<String, String> rt = new HashMap<>();
        for(String k : t.keySet()){
            rt.put(t.get(k), k);
        }
        String str = "";
        for(String k : t.keySet()){
            if(!rt.containsKey(k)){
                str = k;
                break;
            }
        }
        System.out.print(str);
        for(String k : t.keySet()){
           System.out.print("->" + t.get(str));
           str = t.get(str);
        }
    }
}
