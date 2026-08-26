public class Koko{
    private boolean works(int piles[], int h, int k){
        double count = 0;
        for(int i=0;i<piles.length;i++){
            double t = Math.ceil((double)piles[i]/k);
            count  += t;
        }
        return count <= h ? true : false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int n : piles){
            max = Math.max(max,n);
        }
        int l = 1;
        int k =1;
        int r = max;
        while(l < r){
           int mid = (l+r)/2;
           if(works(piles,h,mid)){
             r = mid;
           }else{
             l =mid+1;
           }
        }
        return r;
    }
}