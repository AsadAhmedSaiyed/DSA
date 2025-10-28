public class OddOrEven{

    public static void oddOrEven(int n){

        if( (n & 1) == 1){
            System.out.print("Odd");
        }else{
            System.out.print("Even");
        }
    }
    public static void main(String[] args) {
        oddOrEven(7);
    }
}