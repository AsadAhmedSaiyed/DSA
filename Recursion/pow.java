public class pow {

    public static int pow(int x, int n){
        //1)brute force - O(n)
        if(n == 0){
            return 1;
        }

        return x*pow(x, n-1);
    }
    public static int pow1(int x,int n){
        //optimized - O(logn)
        if(n == 0){
            return 1; 
        }
        int ans;
        int half= pow1(x, n/2);
        if(n % 2 == 0){
            ans =half*half;
        }else{
            ans = x*half*half;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.print(pow1(2 ,10 ));
    }
}
