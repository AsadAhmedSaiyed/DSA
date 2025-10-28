public class CountingSort {

    public static void countingSort(int nums[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            largest= Math.max(largest,nums[i]);
        }

        int count[] = new int[largest+1];

        //counting frequecy of each element
        for(int i=0;i<nums.length;i++){
            count[nums [i]]++;
        }

        //sorting
        //traversing count array
        int j=0;
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                nums[j] = i;
                count[i]--;
                j++;
            }
        }
    }
    public static void main(String[] args) {
        int nums[] = {1,4,1,3,2,4,3,7};
        countingSort(nums);
        for (int i = 0; i < nums.length; i++) {
           System.out.print(nums[i] + " ");   
        }
    }
}
