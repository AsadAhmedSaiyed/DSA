package DP;

public class Intro {
    //memoization
    public static int fib(int n, int f[]){
        if(n == 0 || n == 1){
            return n;
        }
        if(f[n] != 0){
            //fib is already calc
            return f[n];
        }
        f[n] = fib(n-1, f) + fib(n-2,f);
        return f[n];
    }
    //tabulation
    public static int fibTab(int  n){
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<dp.length;i++){
           dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
   public static void main(String[] args) {
    int n=5;
    //fib from 0 to n
    //default store 0
    int f[] = new int[n+1];
      System.out.println(fibTab(n));
   }    
}
