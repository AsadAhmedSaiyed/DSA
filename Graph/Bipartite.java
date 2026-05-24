package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
     static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
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

    public static boolean isBipartite(ArrayList<Edge> graph[]){
        int color[] = new int[graph.length];
        for(int i=0;i<color.length;i++){
            color[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(color[i] == -1){
                q.add(i);
                color[i] = 0;
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                       Edge e = graph[curr].get(j);
                       if(color[e.dest] == -1){
                         int nextCol = color[curr] == 0 ? 1 : 0;
                         color[e.dest] = nextCol;
                         q.add(e.dest);
                       }else if(color[e.dest] == color[curr]){
                         return false;
                       }
                    }
                }
            }
        }
        return true;
    }
   public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];// null -> empty AL
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        createGraph(graph);
        System.out.println(isBipartite(graph));
    }   
}
