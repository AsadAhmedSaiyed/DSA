public class ClearBitsInRange{

    public static void clearBitsInRange(int n,int i,int j){
        int a = ((~0)<<(j+1));
        int b = (1<<(i) - 1);

        int bitMask = a|b;
        System.out.print(n & bitMask);
    }

    public static boolean isPowerOfTwo(int n){
        return ((n&(n-1)) == 0);
    }
    public static void main(String[] args) {
        //clearBitsInRange(10, 2, 4);
        System.out.print(isPowerOfTwo(15));
    }
}














