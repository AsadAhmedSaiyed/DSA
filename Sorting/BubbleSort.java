public class BubbleSort {
    //optimized
    public static void bubbleSort(int arr[]){
        //TC - O(n)
        //if we don't use swap then
        //TC - O(n2)
        int n= arr.length;
        for(int i=0;i<n-1;i++){
            int swap = 0;
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    //swap
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swap++;
                }
            }
            if(swap == 0){
                break;
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {10,5,4,1,3,2};
        bubbleSort(arr);
    }
}
