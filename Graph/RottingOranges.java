import java.util.*;
class RottingOranges{
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int []> q = new LinkedList<>();
        int countFreshOrg = 0;
        int vis[][] = grid;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                if(vis[i][j] == 1){
                    countFreshOrg++;
                }
            }
        }
        if(countFreshOrg == 0){
            return 0;
        }
        if(q.isEmpty()){
            return -1;
        }
        int min =-1;
        int dirs[][] = {{1,0},{-1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int size = q.size();
            while(size> 0){
                size--;
                int org[] = q.remove();
                int x = org[0];
                int y = org[1];
                for(int dir[] : dirs){
                    int i = x + dir[0];
                    int j = y + dir[1];
                    if(i >= 0 && i <m && j >= 0 && j <n && vis[i][j] == 1){
                        vis[i][j] = 2;
                        countFreshOrg--;
                        q.add(new int[]{i,j});
                    }
                }
            }
            min++;
        }
        if(countFreshOrg == 0){
            return min;
        }
        return -1;
    }
}