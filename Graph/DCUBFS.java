import java.util.*;
class DCUBFS {
    private class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt){
            this.src =src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    private void createGraph(ArrayList<Edge> graph[], int edges[][]){
        for(int i=0;i<edges.length;i++){
            graph[edges[i][0]].add(new Edge(edges[i][0],edges[i][1], 1));
            graph[edges[i][1]].add(new Edge(edges[i][1],edges[i][0], 1));
        }
    }
   private boolean bfs(ArrayList<Edge> graph[], boolean vis[], int start, int par) {

    Queue<int[]> q = new LinkedList<>();
    vis[start] = true;
    q.add(new int[]{start, par});

    while (!q.isEmpty()) {
        int curr[] = q.remove();
        int node = curr[0];
        int parent = curr[1];

        for (int i = 0; i < graph[node].size(); i++) {
            Edge e = graph[node].get(i);

            if (!vis[e.dest]) {
                vis[e.dest] = true;
                q.add(new int[]{e.dest, node});
            } else if (e.dest != parent) {
                return true; // cycle found
            }
        }
    }
    return false;
}
    public boolean isCycle(int V, int[][] edges) {
       @SuppressWarnings("unchecked")
       ArrayList<Edge> graph[] = new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }
        createGraph(graph,edges);
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(bfs(graph, vis, i, -1)){
                    return true;
                }
            }
        }
        return false;
    }
}
