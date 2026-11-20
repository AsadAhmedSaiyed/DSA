public class ValidBTree {
    private int find(int rank[], int par[], int i){
        if(par[i] == i) return i;
        return par[i] = find(rank, par, par[i]);
    }
    private void union(int rank[], int par[], int i, int j){
        int parI = find(rank, par, i);
        int parJ = find(rank, par, j);
        if(rank[parI] == rank[parJ]){
            par[parJ] = parI;
            rank[parI]++;
        }
        else if(rank[parI] < rank[parJ]){
            par[parI] = parJ;
        }else{
            par[parJ] = parI;
        }

    }
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
       int rank[] = new int[n];
       int par[] = new int[n];
       for(int i=0;i<n;i++){
         par[i] = i;
       }
       for(int e[] : edges){
         int u = e[0];
         int v = e[1];
         if(find(rank, par, u) == find(rank, par, v)){
            return false;
         }
         union(rank, par, u, v);
       }

       return true;
    }
}
