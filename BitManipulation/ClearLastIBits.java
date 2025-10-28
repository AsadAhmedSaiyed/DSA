public class ClearLastIBits {
    public static void main(String[] args) {
        int n = 15;
        int i=2;
        System.out.print(n&((~0)<<i));
    }
}
