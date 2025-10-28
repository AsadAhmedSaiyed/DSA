import java.util.*;

public class BinarySearch{

    public static int binarySearch(int nums[],int key){
        int start = 0;
        int end = nums.length-1;

        while(start <=end){
            int mid = (start+end)/2;

            //comparisons
            if(nums[mid]>key){//left
              end = mid-1;
            }
            else if(nums[mid] < key){//right
               start = mid +1;
            }else{//found - nums[mid] == key 
               return mid;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        int nums[] = {2,4,6,8,10,12,14};
        int key = 6;

        System.out.print(binarySearch(nums,key));
    }
}