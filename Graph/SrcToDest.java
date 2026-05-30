import java.util.ArrayList;
import java.util.List;

public class SrcToDest {
  
    private void helper(List<Integer> curr, List<List<Integer>> ans, int src, int dest, int graph[][]){
        if(src == dest){
            ans.add(new ArrayList(curr));
            return;
        }
        for(int i=0;i<graph[src].length;i++){
            int e = graph[src][i];
            curr.add(e);
            helper(curr, ans, e, dest, graph);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        helper(curr, ans, 0, graph.length-1, graph);
        return ans;
    }
}
