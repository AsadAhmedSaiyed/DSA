import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnectedComponents {
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
    private void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }
    private void createGraph(ArrayList<Edge> graph[], int edges[][]){
        for(int i=0;i<edges.length;i++){
            graph[edges[i][0]].add(new Edge(edges[i][0],edges[i][1], 1));
        }
    }
    private void topoSort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topoSort(graph, e.dest, vis,s);
            }
        }
        s.push(curr);
    }
    // Function to find number of strongly connected components in the graph
    public int kosaraju(int V, int[][] edges) {
        // code her
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        createGraph(graph,edges);
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topoSort(graph, i, vis, s);
            }
        }
         @SuppressWarnings("unchecked")
        ArrayList<Edge> trans[] = new ArrayList[V];
        for(int i=0;i<graph.length;i++){
            trans[i] = new ArrayList<>();
            vis[i] = false;
        }
        for(int i=0;i<edges.length;i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            trans[dest].add(new Edge(dest,src, 1));
        }
        int count = 0;
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!vis[curr]){
                dfs(trans, curr,vis);
                count++;
            }
        }
        return count;
    }
}    
