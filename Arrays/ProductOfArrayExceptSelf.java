import java.util.Arrays;
public class ProductOfArrayExceptSelf{
    //bf TC and SC O(n)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n];
        Arrays.fill(prefix,1);
        int suffix[] = new int[n];
        Arrays.fill(suffix,1);
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1]*nums[i-1];
        }
        for(int i=n-2;i>=0;i--){
            suffix[i] = suffix[i+1]*nums[i+1];
        }
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = prefix[i]*suffix[i];
        }
        return ans;
    }
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans,1);
        for(int i=1;i<n;i++){
            ans[i] = ans[i-1]*nums[i-1];
        }
        int suffix = 1;
        for(int i=n-1;i>=0;i--){
            ans[i] = ans[i]*suffix;
            suffix *= nums[i];
        }
        return ans;
    }
}