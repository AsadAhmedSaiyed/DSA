import java.util.*;

public class Loops{
   public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      
      //while loop
    //   int i=1;
    //   int sum = 0;
    //   while(i<=n){
    //     sum += i;
    //     i++;
    //   }
    //   System.out.print("sum : " + sum);

    //for loop
    // System.out.print("Enter any number : ");
    //   int n = sc.nextInt();
    // for(int i=0;i<n;i++){
    //   for(int j=0;j<n;j++){
    //     System.out.print("* ");
    //   }
    //   System.out.println();
    // }
    //  System.out.print("Enter any number : ");
    //   int n = sc.nextInt();
    //   int rev = 0;
    //   int r = 0;
    //   int i=0;
    //   while(n>0){
    //     r = n % 10;
    //     rev = rev*10 +r;
    //     i++;
    //     n = n / 10;
    //  }
    //  n = rev;
    //  System.out.print("Reverse : " + n);

    //do while loop

   
    // do{
    //     System.out.print("Enter any number : ");
    //     int n = sc.nextInt();
    //     if(n%10 == 0){
    //         break;
    //     }
    // }while(true);

    // for(int i=0;i<10;i++){
    //     if(i == 5){
    //         continue;
    //     }
    //     System.out.print(i + " ");
    // }
    // int n;
    // do{
    //     if(n % 10 ==0){
    //         continue;
    //     }
    //     System.out.print("Enter any number : ");
    //      n = sc.nextInt();
    // }while(true);

   //checking prime
   //normal approach
   //2 - n-2
    // boolean isPrime = true; 
    // int n = sc.nextInt();
    // for(int i=2;i<n;i++){
    //     if(n%i == 0){
    //         isPrime = false;
    //     }
    // }

    // if(isPrime == true){
    //     System.out.print("it is a prime");
    // }else{
    //     System.out.print("Not a prime");
    // }
   
    //optimized approach
    //2 - underroot n
    // boolean isPrime = true; 
    // int n = sc.nextInt();
    // for(int i=2;i<Math.sqrt(n);i++){
    //     if(n%i == 0){
    //         isPrime = false;
    //     }
    // }

    // if(isPrime == true){
    //     System.out.print("it is a prime");
    // }else{
    //     System.out.print("Not a prime");
    // }
    // int odd=0,even=0;
    // int n = sc.nextInt();
    // for(int i=1;i<=n;i++){
    //     if(i%2 == 0){
    //       even += i;
    //     }else{
    //         odd += i;
    //     }
    // }
    // System.out.println("sum of odd integers : " + odd);
    // System.out.println("sum of even integers : " + even);

    int n = sc.nextInt();
    // int fact =1;
    // if(n == 0){
    //     System.out.print("factorial : " + fact);
    // }else if(n > 0){
    //     for(int i=1;i<=n;i++){
    //         fact *= i;
    //     }
    //     System.out.print("factorial : " + fact);
    // }

    for(long i=1;i<=10;i++){
        System.out.println(n + "*" + i + "=" + n*i);
    }

   }
}