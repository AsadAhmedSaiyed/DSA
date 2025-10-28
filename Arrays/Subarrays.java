public class Subarrays {
    public static void printSubarrays(int nums[]){
        int tSA = 0;
        int maxSum=Integer.MIN_VALUE,minSum = Integer.MAX_VALUE;
        //accessing each element of array and starting index of subarray
        for(int i=0;i<nums.length;i++){
            //choose ending index of subarray
            for(int j=i;j<nums.length;j++){
                int sum = 0;
                //printing all elements b/w them
                for(int k=i;k<=j;k++){
                    System.out.print(nums[k] + " ");
                    sum += nums[k];
                }
                if(sum > maxSum){
                    maxSum = sum;
                }
                if(sum<minSum){
                    minSum = sum;
                }
                System.out.println();
                tSA++;
            }
            System.out.println();
        }
        System.out.println(tSA);
        System.out.println("Max sum : " + maxSum);
        System.out.println("Min sum : " + minSum);
    }
   public static void main(String[] args) {
     int nums[] = {2,4,6,8,10};
     printSubarrays(nums);
   }    
}
