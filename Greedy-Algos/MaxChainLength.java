import java.util.*;

class MaxChainLength{
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,Comparator.comparingInt(o->o[1]));
        int l=1;
        int lastEnd = pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0] > lastEnd){
                l++;
                lastEnd = pairs[i][1];
            }
        }
        return l;
    }
}