public class MaxSubarraySum {
    public static void MaxSubarraySum1(int nums[]){
        //brute force 
        //tl - O(n3)
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int sum = 0; 
                for(int k=i;k<=j;k++){
                    sum += nums[k];
                }
                if(sum > maxSum){
                    maxSum = sum;
                }
                System.out.println("Current sum : "+ sum);
            }
        }
        System.out.println("Max sum : " + maxSum);
    }

   
    public static void MaxSubarraySum2(int nums[]){
        //optimized
        //tc - O(n2)
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            for(int j=i;j<nums.length;j++){
                sum += nums[j];
                if(sum > maxSum){
                    maxSum = sum;
                }
                System.out.println("Current sum : "+ sum);
            }
        }
        System.out.println("Max sum : " + maxSum);
    }

    public static void prefixSum(int nums[]){
        int maxSum=Integer.MIN_VALUE;
        int prefix[] = new int[nums.length];

        prefix[0] = nums[0];
        //storing elements in prefix array
        for(int i=1;i<nums.length;i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        for(int i=0;i<nums.length;i++){
            int start = i;
            for(int j=i;j<nums.length;j++){
                int end = j;
                int sum = start==0 ? prefix[end] : prefix[end] - prefix[start-1]; 
                
                if(sum > maxSum){
                    maxSum = sum;
                }
                System.out.println("Current sum : "+ sum);
            }
        }
        System.out.println("Max sum : " + maxSum);
    }
   public static void main(String[] args) {
     int nums[] = {1,-2,6,-1,3};
     prefixSum(nums);
   }    
}
