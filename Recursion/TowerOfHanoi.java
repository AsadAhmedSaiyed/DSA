public class TowerOfHanoi {
    public static void transfer(int n,char src, char help, char dest){
        if(n == 1){
          System.out.println("Move "+n+" from "+ src+ " to "+dest);  
          return;  
        }
        transfer(n-1, src, dest, help);
        System.out.println("Move "+n+" from "+ src+ " to "+dest);
        transfer(n-1, help, src, dest);
    }
    public static void main(String[] args) {
        transfer(3, 'A', 'B', 'C');
    }
}
