import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightWithinKStops {
    private class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    private class Info{
        int v;
        int cost;
        int stop;
        public Info(int v, int cost, int stop){
            this.v = v;
            this.cost = cost;
            this.stop = stop;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int f[] : flights){
            graph[f[0]].add(new Edge(f[0], f[1], f[2]));
        }
       Queue<Info> q = new LinkedList<>();
       int dist[] = new int[n];
       for(int i=0;i<n;i++){
         if(i != src){
            dist[i] = Integer.MAX_VALUE;
         }
       }
       q.add(new Info(src,0,0));
       while(!q.isEmpty()){
         Info curr = q.remove();
         if(curr.stop >=k+1){
            continue;
         }

         for(int i=0;i<graph[curr.v].size();i++){
            Edge e = graph[curr.v].get(i);
            int next = e.dest;
            int newStop = curr.stop + 1;
            if(newStop <= k+1 && curr.cost + e.wt < dist[next]){
                dist[next] = curr.cost + e.wt;
                q.add(new Info(next, curr.cost + e.wt, newStop));
            }
         }
       }
       if(dist[dst] == Integer.MAX_VALUE){
         return -1;
       }else{
        return dist[dst];
       }
    }
}
