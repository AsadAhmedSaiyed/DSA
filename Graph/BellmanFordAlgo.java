public class BellmanFordAlgo {

    public int[] bellmanFord(int V, int[][] edges, int src) {
        int dist[] = new int[V];
        for(int i=0;i<dist.length;i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<V;i++){
            for(int e[] : edges){
                int u = e[0];
                int v = e[1];
                int w = e[2];
                if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                    if(i == V-1){
                        return new int[]{-1};
                    }
                    dist[v] = dist[u] + w;
                }
            }
        }
        return dist;
    }
}
