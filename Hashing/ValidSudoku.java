import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int row = 0; row<9;row = row + 3){
            for(int col = 0; col< 9;col = col + 3){
                HashSet<Character> s = new HashSet<>();
                for(int i=row;i<row+3;i++){
                    for(int j=col;j<col+3;j++){
                        if(board[i][j] == '.') continue;
                        if(s.contains(board[i][j])) return false;
                        s.add(board[i][j]);
                    }
                }
            }
        }
        for(int i=0;i<9;i++){
            HashSet<Character> s = new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j] == '.') continue;
                if(s.contains(board[i][j])) return false;
                s.add(board[i][j]);
            }
        }  
        for(int j=0;j<9;j++){
            HashSet<Character> s = new HashSet<>();
            for(int i=0;i<9;i++){
                if(board[i][j] == '.') continue;
                if(s.contains(board[i][j])) return false;
                s.add(board[i][j]);
            }
        }  
        return true; 
    }
}
