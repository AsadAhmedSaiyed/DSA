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
}