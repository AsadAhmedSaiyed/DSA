
import java.util.HashSet;
import java.util.Iterator;

public class Set {
    public static void main(String[] args) {
        HashSet<Integer> s = new HashSet<>();
        s.add(1);
        s.add(2);
        s.add(4);
        s.add(2);
        s.add(1);
        Iterator it = s.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        for(Integer n : s){
            System.out.print(n + " ");
        }
        System.out.println("");
        System.out.println(s);
        s.remove(4);  
        System.out.println(s.contains(8));
        System.out.println(s);
        s.clear();
        System.out.println(s.size());
        System.out.println(s.isEmpty());
    }
}
