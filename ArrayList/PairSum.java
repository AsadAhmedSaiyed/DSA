
import java.util.ArrayList;

public class PairSum {

    //brute force - O(n2)
    public static boolean pair(ArrayList<Integer> list, int target){
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                int sum = list.get(i) + list.get(j);
                if(sum == target){
                    return true;
                }
            }
        }
        return false;
    }
    //optimized - O(n)
    public static boolean pairSum(ArrayList<Integer> list, int target){
        int lp = 0;
        int rp = list.size()-1;
        while(lp < rp){
            if((list.get(lp) + list.get(rp)) == target){
                return true;
            }
            else if((list.get(lp) + list.get(rp)) > target){
                rp--;
            }else{
                lp++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target = 5;
        System.out.println(pairSum(list, target));
    }
}
