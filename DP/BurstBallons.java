import java.util.*;
public class BurstBallons{
    private int helper(ArrayList<Integer> arr){
            if(arr.isEmpty()){
                return 0;
            }
            int max = 0;
            for(int i=0;i<arr.size();i++){
                int curr = arr.get(i);
                int l = i == 0 ? 1 : arr.get(i-1);
                int r = i == arr.size()-1 ? 1 : arr.get(i+1);
                int coins = l*curr*r;
                arr.remove(i);
                max = Math.max(max,coins + helper(arr));
                arr.add(i,curr);
            }
            return max;
        }
    public int maxCoins(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int num : nums){
            arr.add(num);
        }
        return helper(arr);
    }
    private int helper(int arr[], int l, int r, int dp[][] ){
       if(l > r){
         return 0;
       }
       if(dp[l][r] != 0){
         return dp[l][r];
       }
       
       for(int i=l+1;i<r;i++){
          int coins = arr[l]*arr[i]*arr[r];
          coins += (helper(arr,l,i,dp) + helper(arr,i,r,dp));
          dp[l][r] = Math.max(dp[l][r], coins);
       }
       return dp[l][r];
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n+2];
        arr[0] = arr[n+1] = 1;
        for(int i=0;i<n;i++){
            arr[i+1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        return helper(arr,0,n+1,dp);
        
    }
}