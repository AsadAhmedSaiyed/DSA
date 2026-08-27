package Intervals;

import java.util.ArrayList;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        ArrayList<int[]> arr = new ArrayList<>();
        
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            arr.add(intervals[i]);
            i++;
        }

        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        arr.add(newInterval);

        while(i < intervals.length){
            arr.add(intervals[i]);
            i++;
        }

        int ans[][] = new int[arr.size()][2];
        for(int j=0;j<arr.size();j++){
            ans[j][0] = arr.get(j)[0];
            ans[j][1] = arr.get(j)[1];
        }
        return ans;
    }
}
