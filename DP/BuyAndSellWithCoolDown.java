public class BuyAndSellWithCoolDown{
    
    private int helper(int prices[], int i, boolean canBuy){
        if(i >= prices.length){
            return 0;
        }
        if(canBuy == false){
            int c1 = helper(prices, i+1,false);
            int c2 = prices[i] + helper(prices, i+2, true);
            return Math.max(c1,c2);
        }else{
            int c1 =  helper(prices, i+1, true);
            int c2 = -prices[i] + helper(prices, i+1, false);
            return Math.max(c1,c2);
        }
    }
    public int maxProfit(int[] prices) {
        return helper(prices, 0, true);
    }

    private int helper2(int prices[], int i, boolean canBuy, int dp[][]){
        if(i >= prices.length){
            return 0;
        }
        if(dp[i][canBuy ? 1 : 0] != 0){
            return dp[i][canBuy ? 1 : 0];
        }
        if(canBuy == false){
            int c1 = helper2(prices, i+1,false, dp);
            int c2 = prices[i] + helper2(prices, i+2, true, dp);
            return dp[i][canBuy ? 1 : 0] = Math.max(c1,c2);
        }else{
            int c1 =  helper2(prices, i+1, true, dp);
            int c2 = -prices[i] + helper2(prices, i+1, false, dp);
            return dp[i][canBuy ? 1 : 0] = Math.max(c1,c2);
        }
    }
    public int maxProfit2(int[] prices) {
        int dp[][] = new int[prices.length+1][2];
        return helper2(prices, 0, true, dp);
    }
    public int maxProfit3(int[] prices) {
        int currBuy = 0;
        int currSell = 0;
        int nextBuy = 0;
        int nextSell = 0;
        int next2Buy = 0;
        int next2Sell = 0;
        for(int i= prices.length-1;i>=0;i--){
            currBuy = Math.max(-prices[i] + nextSell, nextBuy);
            currSell = Math.max(prices[i] + next2Buy, nextSell);

            next2Buy = nextBuy;
            nextBuy = currBuy;

            next2Sell = nextSell;
            nextSell = currSell;
        }
        return nextBuy;
    }
}