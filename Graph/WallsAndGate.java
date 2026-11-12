import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGate {
    private class Cell{
        int i;
        int j;
        public Cell(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        Queue<Cell> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                  q.add(new Cell(i,j));
                }
            }
        }
        if(q.size() == 0) return; 
        int dirs[][] = {{-1,0}, {0,-1}, {1,0}, {0,1}};    
        while(!q.isEmpty()){
            Cell c = q.remove();
            for(int dir[] : dirs){
                int row = c.i + dir[0];
                int col = c.j + dir[1];
                if(row >= m || col >=n || row <0 || col < 0 || grid[row][col] != Integer.MAX_VALUE){
                    continue;
                }
                q.add(new Cell(row,col));
                grid[row][col] = grid[c.i][c.j] + 1;
            }
        }
    }
}
