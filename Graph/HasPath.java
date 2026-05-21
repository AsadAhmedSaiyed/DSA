package Graph;

import java.util.*;
class HasPath {
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
    private boolean dfs(ArrayList<Edge> graph[], int src, int dest, boolean vis[]){
        if(src == dest){
            return true;
        }
        vis[src] = true;
        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            if(!vis[e.dest] && dfs(graph, e.dest, dest,vis)){
                return true;
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        createGraph(graph,edges);
        return dfs(graph,source,destination, new boolean[n]);    
    }
}