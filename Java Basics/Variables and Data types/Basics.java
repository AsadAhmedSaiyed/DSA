import java.util.*;

// variables and data types
//boilerplate code
//defining a class and filename and class name should be same

public class Basics{
    //defining a fxn
   public static void main(String args[]){
      //all logic
   //   System.out.print("* * * *\n");
   //   System.out.print("* * *\n");
   //   System.out.print("* *\n");
   //   System.out.print("*");

   //  int a = 10;
   //  String name = "Asad Ahmed Saiyed";
   //  System.out.println(name);
   //  a=100;
   //  System.out.print(a);
  
   //   byte a = 9;
   //   System.out.print(a);
   //   char ch = 'a';
   //   System.out.print(ch);

   //  int a =10;
   //  int b=20;
   //  int sum = a + b;
   //  System.out.print(sum);

     Scanner sc = new Scanner(System.in);
   //   String name = sc.next();
   //   System.out.print(name);
   
   //  String name = sc.nextLine();
   //  System.out.print(name);
    
   //  int number = sc.nextInt();
   //  System.out.print(number);
     
     //float
    
   //  float a = sc.nextFloat();
   //  System.out.print(a);

   //  double dbl = sc.nextDouble();
   //  System.out.print(dbl);
   //  boolean bool = sc.nextBoolean();
   //  System.out.print(bool);
   //  short small = sc.nextShort();
   //  System.out.print(small);
   //  long large = sc.nextLong();
   //  System.out.print(large);

   // int a = sc.nextInt();
   // int b = sc.nextInt();
 
   //int sum = a+b;
   // int product = a*b;

   float rad = sc.nextFloat();
   //java auto. consider a decimal literal as double
    
    //converts it to the float
    float area = 3.14f*rad*rad;
    System.out.print(area);
   }
}