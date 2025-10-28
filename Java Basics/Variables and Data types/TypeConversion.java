import java.util.*;

public class TypeConversion{
    public static void main(String args[]){
    //    int a= 25;
    //    long b=a;
      //type conversion - implicit
    //   long a = 10;
    //   int b = a;
    //    System.out.print(b); 

    //type casting - explicit
    // float c = 12.5f;
    //  int d = (int)c;
    //  System.out.print(d);

    //type promotion

    // char a ='a';
    // char b = 'b';

    // System.out.println((int)a);
    // System.out.println((int)b);
    // System.out.println(a);
    // System.out.print(b-a);

    //operators

    // float a = 12.45f;
    // int b = 4;
    
    // float c  = a+b;
    // System.out.print(c);
 
    Scanner sc = new Scanner(System.in);
    //   int a = 10;
    //   int b = 5;
    //  int _ = 24;
    //  System.out.print("add = " + (a+b));
    //  System.out.print("add = " + a+b);

    // int a = 10;
    // int b = ++a;
    // int c = a++;
    // System.out.println(a);
    //  System.out.println(b);
    //  System.out.println(c);
    // int a = 10;
    // int b = --a;
    // int c = a--;
    // System.out.println(a);
    //  System.out.println(b);
    //  System.out.println(c);
  
    //  int a = 10;
    // int b = 10;
    // System.out.println(a == b);
    // int b = 10;
    // b %= 2;
    // System.out.print(b);

    float x,y,z;
    x=y=z=2.5f;
    x += y;
    y+=z;
    z /= (x+y);
    System.out.print(x + " " + y + " " + z);
     
    }
}