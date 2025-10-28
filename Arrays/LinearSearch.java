import java.util.*;

public class LinearSearch{
    
    //linear search
    public static int linearSearch(int nums[],int key){
       for(int i=0;i<nums.length;i++){
         if(nums[i] == key){
            return i;
         }
       }
       return -1;
    }

    public static int linearSearch(String nums[],String key){
       for(int i=0;i<nums.length;i++){
         if(nums[i] == key){
            return i;
         }
       }
       return -1;
    }

    public static int largest(int nums[]){
      int largest = Integer.MIN_VALUE;
      
      for(int i=0;i<nums.length;i++){
         if(nums[i] > largest){
            largest = nums[i];
         }  
      }

      return largest;
    }
    public static void main(String args[]){
        String menu[] = {"apple","banana","orange"};
        int nums[] = {2,4,6,8,10,12,14,16};
        int key=20;
        //int index = linearSearch(nums,key);
        // int index = linearSearch(menu,"apple");
        // if(index == -1){
        //   System.out.print("Not found!");
        // }else{
        //     System.out.print("key is at index : " + index);
        // }
        int roll[] = {1,20,3,4,5};
        System.out.print(largest(roll));
    }
}