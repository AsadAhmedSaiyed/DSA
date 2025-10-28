public class NQueens {
    static int count = 0;
//print all solutions 
    public static boolean isSafe(char board[][],int row,int col){
  
        //vertically
        for (int i = row-1; i >= 0; i--) {
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        //diag left up
        for (int i = row-1,j=col-1; i >= 0 && j>=0; i--,j--) {
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        //diag right up
         for (int i = row-1,j=col+1; i >= 0 && j<board.length; i--,j++) {
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void printBoard(char board[][]){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j] + " ");
            }
             System.out.println();
        }
    }
    public static void place(char board[][],int row){

        if(row == board.length){
            //System.out.println("----------------");
            //printBoard(board);
            count++;
            return;
        }

        //column
        for (int i = 0; i < board.length; i++) {
            if(isSafe(board,row,i)){
               board[row][i] = 'Q';
                place(board, row+1); 
                board[row][i] = 'X';//backtracking step
            }
        }
    } 
    public static void main(String[] args) {
        int n=1;
        char board[][] = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = 'X';
            }
        }
 
        place(board, 0);       
        System.out.println(count +" ways");
    }
}
