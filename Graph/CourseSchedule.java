import java.util.ArrayList;

public class CourseSchedule {
    private class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    private boolean dfs(int i, ArrayList<Edge> g[], boolean vis[], boolean path[]){
        vis[i] = true;
        path[i] = true;
        for(int j=0;j<g[i].size();j++){
            Edge e = g[i].get(j);
            if(path[e.dest]) return true;
            if(!vis[e.dest] && dfs(e.dest, g, vis, path)){
                return true;
            }
        }
        path[i] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       ArrayList<Edge> g[] = new ArrayList[numCourses];
       for(int i=0;i<g.length;i++){
         g[i] = new ArrayList<>();
       }
       for(int pre[] : prerequisites){
          g[pre[1]].add(new Edge(pre[1], pre[0]));
       }
       boolean vis[] = new boolean[numCourses];
       boolean path[] = new boolean[numCourses];

       for(int i=0;i<g.length;i++){
          if(!vis[i]){
             if(dfs(i, g, vis, path)){
                 return false;
             }
          }
       }
       return true;
    }
}
