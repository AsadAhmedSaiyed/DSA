public class UpdateIthBit { 

    public static int clearIthBit(int n,int i){
        return (n & ~(1<<i));
    }
     public static int setIthBit(int n,int i){
        return (n | (1<<i));
    }
    public static int updateIthBit(int n, int i, int newBit){
        
        //1)
        // if(newBit == 0){
        //     return clearIthBit(n, i);
        // }else{
        //     return setIthBit(n, i);
        // }

        //2)
        n = clearIthBit(n, i);
        return (n | (newBit << i));
    }
   public static void main(String[] args) {
     System.out.print(updateIthBit(10, 2, 1));
   }    
}
