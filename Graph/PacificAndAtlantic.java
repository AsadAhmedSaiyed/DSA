import java.util.*;

public class PacificAndAtlantic{
    private void bfs(int i, int j, boolean vis[][], int heights[][]){
        Queue<int []> q = new LinkedList<>();
        int dirs[][] = {{-1,0}, {0,-1}, {1,0}, {0,1}};
        int m = heights.length;
        int n = heights[0].length;
        q.add(new int[]{i,j});
        vis[i][j] = true;
        while(!q.isEmpty()){
            int curr[] = q.remove();
            for(int dir[] : dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if(r >=0 && c >=0 && r < m && c <n && !vis[r][c] && heights[r][c] >= heights[curr[0]][curr[1]]){
                    vis[r][c] = true;
                    q.add(new int[]{r,c});
                }
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean pacificVisited[][] = new boolean[m][n];
        boolean atlanticVisited[][] = new boolean[m][n];
     
        for(int i=0;i<m;i++){
           bfs(i, 0,  pacificVisited, heights);
           bfs(i ,n-1,  atlanticVisited, heights);
        }

        for(int j=0;j<n;j++){
           bfs(0, j,  pacificVisited, heights);
           bfs(m-1 ,j, atlanticVisited, heights);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacificVisited[i][j] && atlanticVisited[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }

        return ans;
    }
}