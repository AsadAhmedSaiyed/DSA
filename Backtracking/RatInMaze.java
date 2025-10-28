public class RatInMaze {
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,1,-1};
    static char dir[] = {'U','D','R','L'};
    public static void ways(int maze[][],int row,int col, String path){
        //out of bound
        if(row >= maze.length || col >= maze[0].length || row < 0 || col < 0){
            return;
        }
        //bloacked cells
        if(maze[row][col] == -1 || maze[row][col] == 1){
            return;
        }
        //BC
        if(row == maze.length-1 && col == maze[0].length-1){
            System.out.println("way : " + path);
            return;
        }
        maze[row][col] = -1;
        for(int i=0;i<dr.length;i++){
            int nr = row + dr[i];
            int nc = col + dc[i];
            ways(maze, nr, nc,path + dir[i]);
        }
        maze[row][col] = 0;//backtracking
    }
    public static void main(String[] args) {
        int maze[][]= {
            {0,0,0,1},
            {0,1,0,1},
            {0,0,0,0},
            {0,1,1,0}
        };
        ways(maze, 0, 0,"");
    }
}
