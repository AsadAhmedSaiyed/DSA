public class PairingFriends {
    public static int ways(int n){
        if(n == 1 || n== 2){
            return n;
        }
        int single = ways(n-1);
        int pair = (n-1)*ways(n-2);
        return (single+pair);
    }
    public static void main(String[] args) {
        int n=4;
        System.out.print(ways(3));
    }
}
