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

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n-1);
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i] +  " ");
        }
    }

}
