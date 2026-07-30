import java.util.TreeMap;

public class HandStraight {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize != 0){
            return false;
        }
        TreeMap<Integer, Integer> t = new TreeMap<>();
        for(int h : hand){
            t.put(h,t.getOrDefault(h,0)+1);
        }
        while(t.size()>0){
           int start = t.firstKey();
           for(int i=start;i<start+groupSize;i++){
               if(!t.containsKey(i)){
                  return false;  
               }
               t.put(i,t.get(i)-1);
               if(t.get(i) == 0){
                 t.remove(i);
               }
           } 
        }
        return true;
    }
}
