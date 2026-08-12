import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans  = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int x = nums[i];
            int l = i+1;
            int r = nums.length-1;
            while(l<r){
                if(nums[l] + nums[r] > -x){
                    r--;
                }else if(nums[l] + nums[r] < -x){
                    l++;
                }else{
                    List<Integer> arr = new ArrayList<>();
                    arr.add(x);
                    arr.add(nums[l]);
                    arr.add(nums[r]);
                    ans.add(arr);
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l-1]) l++;
                    while(r > l && nums[r] == nums[r+1]) r--;   
                }
            }
        }
        return ans;
    }
}
