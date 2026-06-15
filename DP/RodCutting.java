public class RodCutting {
    //recursion
    private int helper(int idx, int price[], int l){
       if(idx == 0){
           return l*price[0];
       }    
       if(l == 0){
           return 0;
       }        
       int notCut = helper(idx-1, price,l);
       int cut = Integer.MIN_VALUE;
       int rodLength = idx + 1;
       if(rodLength <=l){
           cut = price[idx] + helper(idx,price, l-rodLength);
       }
       
       return Math.max(notCut, cut);
        
    }
    public int cutRod(int[] price) {
        int n = price.length;
        return helper(n-1,price,n);
    }
    //tabulation
       public int cutRod2(int[] price) {
        int n = price.length;
        //length of rod
        int dp[] = new int[n+1];
        
        for(int len = 1;len<=n;len++){
            //length of cut
            for(int cut = 1; cut<=len;cut++){
                dp[len] = Math.max(dp[len], price[cut-1] + dp[len-cut]);
            }
        }
        return dp[n];
    }
}
