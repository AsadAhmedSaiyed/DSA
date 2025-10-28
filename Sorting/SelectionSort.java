public class SelectionSort {

 public static void selectionSort(int arr[]){
    int n = arr.length;
    for(int i=0;i<n-1;i++){
        int min=i;
        //take min number from i+1 to n-1
        for(int j=i+1;j<n;j++){
            if(arr[j]<arr[min]){
                min = j;
            }
        }
        //swap arr[min] and min number
        int temp = arr[min];
        arr[min] = arr[i];
        arr[i] = temp;
    }
    for (int i = 0; i < n; i++) {
        System.out.print(arr[i] + " ");
    }
 }
  public static void main(String[] args) {
    int arr[] = {5,4,1,3,2};
    selectionSort(arr);
  }    
}
