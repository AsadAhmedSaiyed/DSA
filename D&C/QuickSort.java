class QuickSort{

    public static void print(int arr[]){
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }

    public static void quickSort(int arr[], int si, int ei){
        if(si >= ei){
            return;
        }
        int pIdx = partition(arr,si,ei);
        quickSort(arr, si, pIdx-1);//left
        quickSort(arr, pIdx+1, ei);//right
    }

    public static int partition(int arr[], int si, int ei){
       int pivot = arr[ei];
       int i = si-1;//to make place for els smaller than pivot
       for(int j=si;j<ei;j++){
         if(arr[j] <= pivot){
            i++;
            //swap
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
         }
       }
       i++;
         int temp = pivot;
         arr[ei] = arr[i];//not pivot = arr[i] because we need to change in arr not in pivot 
         arr[i] = temp;
         return i;
    }

    public static void main(String[] args) {
        int arr[] = {6,3,9,8,2,5};
        quickSort(arr, 0, arr.length-1);
        print(arr);
    }
}