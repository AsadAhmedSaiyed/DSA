import java.util.*;
public class InbuiltSort {
    public static void main(String[] args) {
        Integer nums[] = {5,4,1,3,2};
        //ascending order
        //Arrays.sort(nums,0,3,Collections.reverseOrder());
        Arrays.sort(nums,0,3,Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i] + " ");
        }
    }
}
