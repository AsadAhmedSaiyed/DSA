import java.util.*;

public class Star{

    //inverted and rootated half pyramid
    public static void irhp(int n){
        for(int i=1;i<=n;i++){
            //spaces
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            //star
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
        //  int a = n;
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=a;j++){
        //         System.out.print("* ");
        //     }
        //     a--;
        //     System.out.println();

        //half pyramid
        // char ch = 'A';
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=i;j++){
        //         System.out.print(" "+ch);
        //         ch++;
        //     }
        //     System.out.println();
        // }

        // for(int i=1;i<=(n/2+1);i++){
        //     for(int j=1;j<=i;j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }
        // for(int i=(n/2);i>=1;i--){
        //     for(int j=1;j<=i;j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        //hollow rectangle
        // int n = sc.nextInt();
        // int m = sc.nextInt();
        // for(int i=1;i<=n;i++){
        //     if(i == 1 || i==n){
        //         for(int j=1;j<=m;j++){
        //           System.out.print("* ");
        //         }
        //         System.out.println();
        //     }else{
        //         for(int j=1;j<=m;j++){
        //           if(j == 1 || j== m){
        //             System.out.print("* ");
        //           }else{
        //             System.out.print("  ");
        //           }
        //         }
        //         System.out.println();
        //     }
        // }

        // int n = sc.nextInt();
        // int m = sc.nextInt();
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=m;j++){
        //         if(i == 1 || i == n || j==1 || j== m){
        //             System.out.print("* ");
        //         }else{
        //             System.out.print("  ");
        //         }
        //     }
        //     System.out.println();
        // }

        // irhp(5);
         for(int i=1;i<=(n/2+1);i++){
             for(int j=1;j<=i;j++){
                 System.out.print("* ");
             }
             System.out.println();
         }
         for(int i=(n/2);i>=1;i--){
             for(int j=1;j<=i;j++){
                 System.out.print("* ");
             }
             System.out.println();
         }

    }
}
