public class CoinChange {
    //recursion O(C^A)
    private int helper(int coins[], int amount) {

        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = helper(coins, amount - coin);

            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, res + 1);
            }
        }

        return min;
    }

    public int coinChange(int[] coins, int amount) {
        int ans = helper(coins, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    //memo O(N*A)
     private int helper2(int coins[], int amount, int memo[]){
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return Integer.MAX_VALUE;
        }
        if(memo[amount] != 0){
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for(int coin : coins){
           int res = helper2(coins, amount-coin, memo); 
           if(res != Integer.MAX_VALUE){
             min = Math.min(min,1 + res); 
           }
        }
        memo[amount] = min;
        return memo[amount];
    }
    public int coinChange2(int[] coins, int amount) {
       int memo[] = new int[amount+1]; 
       int ans = helper2(coins, amount,memo);
       return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    //tab
     public int coinChange3(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        for(int i=1;i<dp.length;i++){
            dp[i] = amount+1;
        }
        for(int i=1;i<=amount;i++){
            for(int coin : coins){
                if(i-coin >= 0 ){
                    dp[i] = Math.min(dp[i], dp[i-coin] +1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
