public class DiagonalSum {

    public static int diagonalSum(int matrix[][]){

        //brute force - O(n2)
        // int sum =0;
        // for(int i=0;i<matrix.length;i++){
        //    for(int j=0;j<matrix[0].length;j++){
        //      if(i == j){
        //         sum += matrix[i][j];
        //      }
        //      else if(i+j == matrix.length-1){
        //         sum += matrix[i][j];
        //      }
        //    }
        // }
        // return sum;

        int sum = 0;
        for(int i=0;i<matrix.length;i++){
          //pd
          sum += matrix[i][i];

          //sd
          if(i != matrix.length-1-i) {
            sum += matrix[i][matrix.length-1-i];
          }
        }
        return sum;
    }
    public static void main(String[] args) {
        int matrix[][] ={
          {0,1,2},
          {3,4,5},
          {6,7,8}
        };
        System.out.print(diagonalSum(matrix));
    }
}
