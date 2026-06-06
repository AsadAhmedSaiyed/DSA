import java.util.Arrays;

public class KruskalsAlgo {
    static int rank[];
    static int par[];

    static int kruskalsMST(int V, int[][] edges) {
        rank = new int[V];
        par = new int[V];
        for (int i = 0; i < V; i++) {
            par[i] = i;
        }
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        int cost = 0;
        int count = 0;
        for (int e[] : edges) {
            int src = e[0];
            int dest = e[1];
            int wt = e[2];
            if (count == V)
                break;
            if (find(src) == find(dest)) {
                continue;
            } else {
                count++;
                cost += wt;
                union(src, dest);
            }
        }
        return cost;

    }

    static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (rank[parA] == rank[parB]) {
            par[parA] = parB;
            rank[parB]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

}
