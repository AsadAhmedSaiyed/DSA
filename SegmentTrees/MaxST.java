package SegmentTrees;

public class MaxST {
    static int tree[];

    public static void init(int n){
        tree = new int[4*n];
    }
    public static void buildST(int arr[], int i, int si, int sj){
       if(si == sj){
         tree[i] = arr[si];
         return;
       }
       int mid = (si + sj)/2;
       buildST(arr, 2*i+1, si, mid);
       buildST(arr, 2*i+2, mid+1, sj);
       tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);

    }
    public static int getMaxUtil(int arr[], int i, int qi, int qj, int si, int sj){
        if(sj < qi || si > qj){
            return Integer.MIN_VALUE;
        }
        else if(si >=qi && sj <= qj){
            return tree[i];
        }else{
           int mid = (si + sj)/2;
           int l = getMaxUtil(arr, 2*i+1, qi, qj, si, mid);
           int r = getMaxUtil(arr, 2*i+2, qi, qj, mid+1, sj);
           return Math.max(l,r);
        }
    }

    public static void updateUtil(int i,int idx , int si, int sj, int newVal){
        if(idx > sj || idx < si){
            return;
        }
        tree[i] = Math.max(tree[i], newVal);
        if(si != sj){
            int mid = (si + sj)/2;
        updateUtil(2*i+1, idx, si, mid, newVal);
        updateUtil(2*i+2, idx, mid+1, sj, newVal);
        }
    }

    public static void update(int arr[], int idx, int newVal){
        int n = arr.length;
        arr[idx] = newVal;
        updateUtil(0,idx, 0, n-1, newVal);
    }

    public static int getMax(int arr[], int qi, int qj){
        int n = arr.length;
        return getMaxUtil(arr, 0,qi, qj, 0, n-1);
    }
    public static void main(String[] args) {
        int arr[] = {6,8,-1,2,17,1,3,2,4};
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n-1);
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println("");
        System.out.println(getMax(arr, 2, 5));
        update(arr, 2, 20);
        System.out.println(getMax(arr, 2, 5));
    }
}
