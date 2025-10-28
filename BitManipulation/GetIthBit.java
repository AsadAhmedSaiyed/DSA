public class GetIthBit {

    public static int getIthBit(int n,int i){
        if((n & (1 << i)) == 0){
           return 0;
        }else{
            return 1;
        }
    }
    public static void main(String[] args) {
        System.out.print(getIthBit(10,3));
    }
}
