public class Kadanes {

    public static void Kadanes(int nums[]){
       int ms = Integer.MIN_VALUE;
       int cs = 0;

       for(int i=0;i<nums.length;i++){
         cs += nums[i];
         //we check max first because if all elements is -ve then it will give
         //max sum = 0 which is incorrect so to store correct value we check max first 
         //then reset cs to 0
         ms = Math.max(cs,ms);
         if(cs <0){
            cs = 0;
         }
       }
       System.out.print("Max subarray sum : " + ms);
    }
    public static void main(String[] args) {
        int nums[] = {-2,-3,-4};
        Kadanes(nums);
    }
}
