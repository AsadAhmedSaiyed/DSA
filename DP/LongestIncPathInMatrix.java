import java.util.Arrays;
public class LongestIncPathInMatrix {
    private int helper(int matrix[][], int i, int j, int m, int n, int memo[][]){
        int len = 1;
        if(memo[i][j] != 0){
            return memo[i][j];
        }
        if(i-1 >= 0 && matrix[i-1][j] < matrix[i][j]){
            len = Math.max(len,helper(matrix, i-1,j,m,n, memo) + 1);
        }
        if(i+1 < m && matrix[i+1][j] < matrix[i][j]){
            len = Math.max(len,helper(matrix, i+1,j, m,n, memo) + 1);
        }
        if(j-1 >=0 && matrix[i][j-1] < matrix[i][j]){
            len = Math.max(len,helper(matrix, i,j-1,m,n, memo) + 1);
        }
        if(j+1<n && matrix[i][j+1] < matrix[i][j]){
            len = Math.max(len,helper(matrix,i,j+1,m,n, memo) + 1);
        }
        return memo[i][j] = len;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n= matrix[0].length;
        int dp[][] = new int[m*n][3];
        int k =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[k][0] = matrix[i][j];
                dp[k][1] = i;
                dp[k][2] = j;
                k++;
            }
        }
        Arrays.sort(dp, (a,b)->Integer.compare(a[0], b[0]));
        int max = 0;
        int memo[][] = new int[m+1][n+1];
        for(int i=0;i<dp.length;i++){
           int l = helper(matrix, dp[i][1], dp[i][2], m,n, memo);
           max = Math.max(max, l);
        }
        return max;
    }
}
