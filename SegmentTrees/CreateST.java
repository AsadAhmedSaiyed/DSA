package SegmentTrees;

public class CreateST {
    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];

    }

    public static int buildST(int arr[], int i, int s, int e) {
        if (s == e) {
            tree[i] = arr[s];
            return tree[i];
        }
        int m = (s + e) / 2;
        buildST(arr, 2 * i + 1, s, m);
        buildST(arr, 2 * i + 2, m + 1, e);
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
        return tree[i];
    }

    public static int getSumUtil(int i, int qi, int qj, int si, int sj){
        if(qj < si || qi > sj){
            return 0;
        }else if(si >= qi && sj <= qj){
            return tree[i];
        }else{
            int mid = (si+ sj)/2;
            int l = getSumUtil(2*i+1, qi, qj, si, mid);
            int r = getSumUtil(2*i+2, qi, qj, mid+1, sj);
            return l + r;
        }
    }

    public static int getSum(int arr[], int qi, int qj){
       int n = arr.length;
       return getSumUtil(0, qi, qj, 0, n-1);
    }
    
    public static void updateUtil(int i, int si, int sj, int idx, int diff){
        if(idx > sj || idx <  si){
            return;
        }
        tree[i] += diff;
        if(si != sj){
            int mid = (si + sj)/2; 
            updateUtil(2*i+1, si, mid, idx, diff);
            updateUtil(2*i+2, mid+1, sj, idx, diff);
        }
    }

    public static void update(int arr[], int idx, int newVal){
        int n = arr.length;
        int diff = newVal - arr[idx];
        arr[idx] = newVal;
        updateUtil(0, 0, n-1, idx, diff);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n-1);
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i] +  " ");
        }
        System.out.println(" " + getSum(arr, 2,5  ));
        update(arr, 2, 2);

        System.out.println(getSum(arr, 2, 5) + " ");
    }

}
