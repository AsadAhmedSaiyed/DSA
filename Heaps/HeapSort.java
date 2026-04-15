public class HeapSort {
    public static void heapify(int arr[], int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;
        if (left < n && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }
        if (right < n && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }
        if (maxIdx != i) {
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
            heapify(arr, maxIdx, n);
        }
    }

    public static void heapSort(int arr[]) {

        // build maxHeap for sorting in asc
        for (int i = (arr.length / 2) - 1; i >= 0; i--) { // O(n/2*logn)
            heapify(arr, i, arr.length);
        }
        // push largest at end
        for (int i = (arr.length - 1); i > 0; i--) {// O(nlogn)
            // swap largest first and with last
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
    }

    public static void make(int arr[], int i, int n) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int maxIdx = i;
        if (l < n && arr[l] > arr[maxIdx]) {
            maxIdx = l;
        }
        if (r < n && arr[r] > arr[maxIdx]) {
            maxIdx = r;
        }
        if(maxIdx != i){
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
            make(arr,maxIdx, n);
        }
    }

    public static void sort(int arr[]) {
        for (int i = (arr.length / 2)-1; i >= 0; i--) {
            make(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            make(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 5, 3 };
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
