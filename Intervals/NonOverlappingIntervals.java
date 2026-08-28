import java.util.Arrays;

public class NonOverlappingIntervals{
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        int idx = 0;
        int count = 0;
        for(int i=1;i<n;i++){
            int curr[] = intervals[i];
            if(intervals[idx][1] > curr[0]){
               count++;
               if(curr[1] < intervals[idx][1]){
                  idx = i;
               }
            }else{
                idx = i;
            }
        }
        return count;   
    }
}