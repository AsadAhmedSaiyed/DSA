public class MaxAreaOfIsland {
    private int dfs(int grid[][], int i, int j, boolean vis[][]){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || vis[i][j]){
            return 0;
        }
        vis[i][j] = true;
        return 1 + dfs(grid, i+1,j, vis) + dfs(grid, i-1,j, vis) + dfs(grid, i,j+1, vis) + dfs(grid, i,j-1, vis);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    int area = dfs(grid, i, j, vis);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}
