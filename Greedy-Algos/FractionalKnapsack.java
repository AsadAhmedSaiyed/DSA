
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int val[] = {60,100,120};
        int w[] = {10,20,30};
        int c = 50;
        double  r[][] = new double[w.length][2];

        for(int i=0;i<w.length;i++){
            r[i][0] = i;
            r[i][1] = val[i]/(double)w[i];
        }
        //ascending
        Arrays.sort(r,Comparator.comparingDouble(o->o[1]));

        int amount=0;
        for(int i=r.length-1;i>=0;i--){  
            int idx = (int)r[i][0];
            if(c >= w[idx]){
                c -= w[idx];
                amount += val[idx];
            }else{
                amount += (r[i][1]*c);
                c=0;
                break; 
            }
        }
        System.out.println(amount);
    }
}
