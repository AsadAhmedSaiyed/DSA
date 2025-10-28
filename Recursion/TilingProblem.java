public class TilingProblem {

    public static int tile(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        int fn1 = tile(n-1);
        int fn2 = tile(n-2);
        return (fn1+fn2);
    }
  public static void main(String[] args) {
    System.out.print(tile(4));
  }    
}
