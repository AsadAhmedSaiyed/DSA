import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
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
        }
    }
    private void helper(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                helper(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }
    private Stack<Integer> topologicalSort(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>(); 
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                helper(graph, i, vis, s);
            }
        }
        return s;
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];// null -> empty AL
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        createGraph(graph,edges);
        Stack<Integer> s = topologicalSort(graph);
        ArrayList<Integer> ans = new ArrayList<>();
        while(!s.isEmpty()){
            ans.add(s.pop());
        }
        return ans;
    }
}
