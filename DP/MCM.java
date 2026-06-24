class MCM{
    //recursion
    private int MCM(int arr[], int i, int j){
        if(i == j){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int c1 = MCM(arr, i,k); // arr[i-1]*arr[k]
            int c2 = MCM(arr, k+1,j);//arr[k]*arr[j]
            int c3 = arr[i-1]*arr[k]*arr[j];
            int cost = c1 + c2 + c3;
            ans = Math.min(ans,cost);
        }
        return ans;
    }
    public int matrixMultiplication(int arr[]) {
        // code here
        return MCM(arr, 1, arr.length-1);
    }
    //memo
     private int MCM2(int arr[], int i, int j, int dp[][]){
        if(i == j){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int c1 = MCM2(arr, i,k, dp); // arr[i-1]*arr[k]
            int c2 = MCM2(arr, k+1,j, dp);//arr[k]*arr[j]
            int c3 = arr[i-1]*arr[k]*arr[j];
            int cost = c1 + c2 + c3;
            ans = Math.min(ans,cost);
        }
        return dp[i][j] = ans;
    }
    public int matrixMultiplication2(int arr[]) {
        // code here
        int dp[][] = new int[arr.length][arr.length];
        return MCM2(arr, 1, arr.length-1,dp);
    }
    //tabulation
      public int matrixMultiplication3(int arr[]) {
        // code here
        int dp[][] = new int[arr.length][arr.length];
        for(int len=2;len<arr.length;len++){
            for(int i=1;i<=arr.length-len;i++){
                int j = i + len-1;
                  dp[i][j] = Integer.MAX_VALUE; 
                for(int k=i;k<j;k++){
                    int c1 = dp[i][k];
                    int c2 = dp[k+1][j];
                    int c3 = arr[i-1]*arr[k]*arr[j];
                    dp[i][j] = Math.min(dp[i][j], c1+c2+c3);
                }
            }
        }
        return dp[1][arr.length-1];
    }
}