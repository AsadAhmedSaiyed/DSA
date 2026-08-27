package Intervals;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
           if(arr.isEmpty()){
              arr.add(intervals[i]);
           }else{
              int curr[] = arr.get(arr.size()-1);
              if((curr[1] >= intervals[i][0]) && (curr[0] <= intervals[i][1])){
                 arr.remove(arr.size()-1);
                 int newInterval[] = new int[2];
                 newInterval[0] = Math.min(curr[0], intervals[i][0]);
                 newInterval[1] = Math.max(curr[1], intervals[i][1]);
                 arr.add(newInterval);
              }else{
                arr.add(intervals[i]);
              }
           }
        }

        int ans[][] = new int[arr.size()][2];
        for(int j=0;j<arr.size();j++){
            ans[j][0] = arr.get(j)[0];
            ans[j][1] = arr.get(j)[1];
        }
        return ans;
    }
}
