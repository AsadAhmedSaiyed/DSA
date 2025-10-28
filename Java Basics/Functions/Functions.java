import java.util.*;

public class Functions{
    //accesss modifier
    public static void printHello(){
        //fxn
        System.out.println("Hello World!");
          System.out.println("Hello World!");
    }

    public static int calSum(int a, int b){//formal para or para
        int sum = a +b;
        return sum;
    }

    public static void swap(int a, int b){//java always call by value
        int temp;
        temp = a;
        a=b;
        b=temp;
        System.out.println("a : "+ a);
      System.out.println("b : "+b);
    }

    public static int fact(int n){
        int fact = 1;
        for(int i=1;i<=n;i++){
            fact *= i;
        }
        return fact;
    }

    public static int binCoef(int n, int r){
        int a = fact(n);
        int b = fact(r);
        int c = fact(n-r);
        int ncr = a/(b*c);
        return ncr;
    }
    //fxn overloading using diff no. of params
    public static int sum(int a, int b){
        return a+b;
    }

    public static int sum(int a, int b, int c){
        return a+b+c;
    }

    //fxn overloading using diff data types of params
    public static int add(int a,int b){
        return a+b;
    }

    public static float add(float a,float b){
        return a+b;
    }
  
    // public static boolean isPrime(int n){
    //     for(int i=2;i<n;i++){
    //         if(n%i == 0){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    //optimized 
    public static boolean isPrime(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void printPrime(int n){
        for(int i=2;i<=n;i++){
            boolean prime = isPrime(i);
            if(prime == true){
                System.out.print(i + " ");
            }
        }
    }

    public static void bToD(int n){

        int pow=0;
        int dec =0;
        while(n>0){
            int ld = n%10;
            dec += ld*((int)Math.pow(2,pow));
            pow++;
            n = n /10;
        }
        System.out.print("Decimal : " + dec);
    }

    public static void DToB(int n){
        int bin =0;
        int pow =0;
        while(n>0){
            int rem = n%2;
            bin += rem*(Math.pow(10,pow));
            pow++;
            n = n/2;
        }
        System.out.print(bin);
    }

    public static boolean isPalindrome(int n){
        int rev = 0;
        int num= n;
        while(n>0){
            int rem = n%10;
            rev = rev*10 + rem;
            n = n/10;
        }
        if(num == rev){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String args[]){
       Scanner sc = new Scanner(System.in);
    //    int a = sc.nextInt();
    //    int b = sc.nextInt();
    //    int sum = calSum(a,b);//arguments or actual para
    //    System.out.println("Sum : " + sum);

    //   swap(a,b);//passed the copies of var
    //   System.out.println("a : "+ a);
    //   System.out.println("b : "+b);
    
    //   int n = sc.nextInt();
    //   int factorial = fact(n);
    //   System.out.print("Factorial : "+ factorial);

    // int n = sc.nextInt();
    // int r = sc.nextInt();

    // int coef = binCoef(n,r);
    // System.out.print("Binomial Coefficient : "+coef);

    //  System.out.println(sum(5,3));
    //  System.out.println(sum(2,3,3));
    //  System.out.println(add(5,3));
    //  System.out.println(add(2.9f,3.1f));
    //  System.out.print(isPrime(16));
    // printPrime(100);
    // bToD(101);
    // DToB(15);

    System.out.print(isPalindrome(321));

    }
}