import java.util.*;

public class Palindrome{

    //palindrome number pyramid
    public static void palindrome(int n){
        for(int i=1;i<=n;i++){
            //spaces
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            //1st 
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            //2nd
            for(int j=(i-1);j>=1;j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void number(int n){
        int a=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                System.out.print("\t");
            }
            for(int j=1;j<=i;j++){
                System.out.print(a + "\t\t");
                a++;
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
    //    palindrome(5);\
     number(5);
    }
}