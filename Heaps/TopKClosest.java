import java.util.*;

class Solution {
    private static class Points implements Comparable<Points>{
        int x;
        int y;
        int distSq;
        int idx;
        public Points(int x, int y, int distSq, int idx){
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }
        @Override
        public int compareTo(Points p2){
            return this.distSq-p2.distSq;
        }

    }
    public int[][] kClosest(int[][] points, int k) {
        int ans[][] = new int[k][2];
        PriorityQueue<Points> pq = new PriorityQueue<>();
        for(int i=0;i<points.length;i++){
            int dist = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            pq.add(new Points(points[i][0], points[i][1], dist, i));
        }
        for(int i=0;i<k;i++){
            Points pts = pq.remove();
            ans[i]  = points[pts.idx];
        }
        return ans;
    }
}