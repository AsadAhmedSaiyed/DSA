
import java.util.ArrayList;

public class DFS {
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

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){

        //visit
        System.out.print(curr + " ");
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
           Edge e =graph[curr].get(i);
           if(!vis[e.dest]){
              dfs(graph, e.dest, vis);
           }
        }

    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];// null -> empty AL
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        createGraph(graph);
        dfs(graph, 0, new boolean[V]);
    }
}
