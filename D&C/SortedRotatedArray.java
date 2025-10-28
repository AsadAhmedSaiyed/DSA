
public class SortedRotatedArray {
    //using iterations
    public static int searchInSortedRotatedArray(int arr[], int target,int si, int ei) {
       int mid = si + (ei-si)/2;
       int i;
       if(arr[mid] == target){
         return mid;
       }
       else if(arr[si]<= arr[mid]){
          if(arr[si] <= target && target <= arr[mid]){
             i = binarySearch(arr, si, mid-1, target);
          }else{
            i = binarySearch(arr, mid+1, ei, target);
          }
       }else{
          if(arr[mid] <= target && target <= arr[ei]){
            i = binarySearch(arr, mid+1, ei, target);
          }else{
            i = binarySearch(arr, si, mid-1, target);
          }
       }
       return i;
    }

    public static int binarySearch(int arr[], int si, int ei, int target) {

        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (target > arr[mid]) {
                si = mid + 1;
            } else if (target < arr[mid]) {
                ei = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 7;
        int idx = searchInSortedRotatedArray(arr, target, 0, arr.length-1);
        System.out.println(idx);

    }
}
