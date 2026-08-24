public class SortedMatrix {
    public static boolean searchInSortedMatrix(int matrix[][],int key){
        //O(nlogm)
        // for(int i=0;i<matrix.length;i++){
        //     int idx = BS(matrix[i],key);
        //     if(idx != -1){
        //         return true;
        //     }
        // }
         return false;

        
    }
    public static int BS(int matrix[],int key){
        int start =0;
        int end = matrix.length-1;
        while (start <= end) { 
            int mid = (start+end)/2;
            if(key > matrix[mid]){
                start =mid+1;
            }
            else if(key< matrix[mid]){
                end = mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = (m*n)-1;
        while(l<=r){
            int mid = (l+r)/2;
            int row = mid/n;
            int col = mid%n;
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] < target){
                l = mid + 1;
            }else{
                r = mid-1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int matrix[][] = {
            {10,20,30,40},
            {15,25,35,45},
            {27,29,37,48},
            {32,33,39,50}
        };
        int key = 3;
        System.out.print(searchInSortedMatrix(matrix, key));
    }
}
