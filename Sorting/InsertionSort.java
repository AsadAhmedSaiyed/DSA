public class InsertionSort {

    public static void insertionSort(int nums[]){
        for(int i=1;i<nums.length;i++){
          int curr = nums[i];
          int prev = i-1;
          //compare curr elemnet with all elements of sorted array
          while(prev >= 0 && nums[prev] > curr){
             //assigning value of prev to next element
             nums[prev+1] = nums[prev];
             prev--;
          }
           nums[prev+1] = curr;
        }
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i] + " ");
        }
    }
    public static void main(String[] args) {
        int nums[] = {5,4,1,3,2};
        insertionSort(nums);
    }
}
