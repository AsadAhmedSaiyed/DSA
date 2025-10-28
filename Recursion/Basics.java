class Basics{
    public static void print(int n){
        if(n == 1){
            System.out.print(1);
            return;
        }
        System.out.print(n+" ");
        print(n-1);
    }
    public static void Inc(int n){
        if(n == 1){
            System.out.print(1 + " ");
            return;
        }
        Inc(n-1);
        System.out.print(n + " ");
    }
    public static int fact(int n){
        if(n == 0){
            return 1;
        }
        return n*fact(n-1);

    }
    public static int sum(int n){
        if(n == 1){
            return 1;
        }
        return (n+sum(n-1));
    }
    public static int fib(int n){
        if(n == 0 || n == 1){
            return n;
        }
        return (fib(n-1)+fib(n-2));
    }
    public static boolean isSorted(int arr[], int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        return isSorted(arr,i+1);
    }

    public static int firstOccur(int arr[],int key,int i){
        if((i == arr.length-1) && (key != arr[i])){
            return -1;
        }
        if(key == arr[i]){
            return i;
        }
        return firstOccur(arr, key, i+1);
    }

    public static int lastOccur(int arr[],int key,int i){
        if(i == 0){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        return lastOccur(arr, key, i-1);
    }
    public static void main(String[] args) {
        // int n = 25;
        // System.out.println(fib(n));

        int arr[] = {4,4,4,4,4,4};
        System.out.print(lastOccur(arr,4,arr.length-1));
    }
}