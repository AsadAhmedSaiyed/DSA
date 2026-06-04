import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimAlgo {

    private class Pair implements Comparable<Pair>{
        int v;
        int cost;
        public Pair(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }
    public int spanningTree(int V, int[][] edges) {
        @SuppressWarnings("unchecked")
        ArrayList<Pair> graph[] = new ArrayList[V];
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        for(int e[] : edges){
            graph[e[0]].add(new Pair(e[1],e[2]));
            graph[e[1]].add(new Pair(e[0],e[2]));
        }
        // code here
        boolean vis[] = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int cost = 0;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(vis[curr.v]) continue;
            
            vis[curr.v] = true;
            cost += curr.cost;
            for(int i=0;i<graph[curr.v].size();i++){
                Pair p = graph[curr.v].get(i);
                if(!vis[p.v]){
                    pq.add(p);
                }
            }
            
        }
        return cost;
    }
}

