import java.util.Arrays;
import java.util.HashSet;
public class LIS {
    //O(n2)
    private int LCS(int nums[], int arr[]){
        int n = nums.length;
        int m = arr.length;
        int dp[][] = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(nums[i-1] == arr[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    int a = dp[i-1][j];
                    int b = dp[i][j-1];
                    dp[i][j] = Math.max(a,b);
                }
            }
        }
        return dp[n][m];
    }
    public int lengthOfLIS(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for(int i=0;i<nums.length;i++){
           s.add(nums[i]);
        }
        int arr[] = new int[s.size()];
        int i=0;
        for(int num : s){
            arr[i] = num;
            i++;
        }
        Arrays.sort(arr);
        return LCS(nums, arr);
    }
}
