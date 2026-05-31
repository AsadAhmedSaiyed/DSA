import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgo {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {
        graph[0].add(new Edge(0, 1, 5));

        // 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        graph[4].add(new Edge(4, 2, 2));

    }
    static class Pair implements Comparable<Pair>{
        int n;
        int d;
        public Pair(int n, int d){
            this.n = n;
            this.d = d;
        }
        @Override
        public int compareTo(Pair p2){
            return this.d - p2.d;
        }
    }
    public static void dijkstra(ArrayList<Edge> graph[], int src){
       int dist[] = new int[graph.length]; //dist src -> i
       for(int i=0;i<graph.length;i++){
          if(i != src){
            dist[i] = Integer.MAX_VALUE;
          }
       }
       PriorityQueue<Pair> pq = new PriorityQueue<>();
       pq.add(new Pair(src, 0));
       boolean vis[] = new boolean[graph.length];
       while(!pq.isEmpty()){
         Pair curr = pq.remove();
          if(!vis[curr.n]){
             vis[curr.n] = true;
             for(int i=0;i<graph[curr.n].size();i++){
                Edge e = graph[curr.n].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if(dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                    pq.add(new Pair(v, dist[v]));
                }
                 
             }
          }
       }
       for(int i=0;i<dist.length;i++){
         System.out.print(dist[i] + " ");
       }
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];// null -> empty AL
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        createGraph(graph);
        int src = 0;
        dijkstra(graph, src);
    }
}
