import java.util.*;
class Solution {
    public static int minCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        int totalCost = 0;
        while(pq.size()>1){
            int a = pq.remove();
            int b = pq.remove();
            int cost = a+b;
            totalCost += cost;
            pq.add(cost);
        }
        return totalCost;
    }
}