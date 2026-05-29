import java.util.*;
class CourseSchedulerII {
    private class Edge{
        int src;
        int dest;
        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    private void createGraph(ArrayList<Edge> graph[], int edges[][]){
        for(int i=0;i<edges.length;i++){
            graph[edges[i][1]].add(new Edge(edges[i][1], edges[i][0]));
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Edge> graph[] = new ArrayList[numCourses];
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        createGraph(graph, prerequisites);
        Queue<Integer> q = new LinkedList<>();
        int indeg[] = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            int v = i;
            for(int j=0;j<graph[v].size();j++){
               Edge e = graph[v].get(j);
               indeg[e.dest]++;
            }
        }
        for(int i=0;i<indeg.length;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        int ans[] = new int[numCourses];
        int i=0;
        while(!q.isEmpty()){
           int curr = q.remove();
           ans[i] = curr;
           i++;
           for(int j=0;j<graph[curr].size();j++){
             Edge e = graph[curr].get(j);
             indeg[e.dest]--;
             if(indeg[e.dest] == 0){
                q.add(e.dest);
             }
           }
        }
        return i == numCourses ? ans : new int[0];
    }
}