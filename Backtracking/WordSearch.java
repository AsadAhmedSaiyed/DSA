public class WordSearch{
    private boolean dfs(char board[][], String word, int idx, int i, int j, boolean vis[][]){
        if(word.length() == idx){
            return true;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.charAt(idx) != board[i][j] || vis[i][j]){
            return false;
        }
        vis[i][j] = true;
        if(dfs(board, word, idx+1, i+1, j, vis) || dfs(board, word, idx+1, i, j+1, vis) || dfs(board, word, idx+1, i, j-1, vis) || dfs(board, word, idx+1, i-1, j, vis)){
            return true;
        }
        vis[i][j] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        boolean vis[][] = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board, word, 0, i,j, vis)){
                    return true;
                }
            }
        }
        return false;
    }
}