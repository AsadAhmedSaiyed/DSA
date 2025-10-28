import java.util.*;

public class Basics{
    public static void main(String args[]){
       
        // System.out.print("Enter your salary : ");
        //int salary = sc.nextInt(); 
        // if(salary <= 5){
        //     System.out.print("tax 0%");
        // }
        // else if(salary > 5 && salary<10){
        //     System.out.print("tax 20%");
        // }else{
        //     System.out.print("tax 30%");
        // }

        // int a = 111,b=3,c=5;
        // if((a>=b) && (a>=c)){
        //     System.out.print("a is largest");
        // }
        // else if(b>c){
        //     System.out.print("b is largest");
        // }else{
        //     System.out.print("c is largest");
        // }
       //ternary operator 

    //    int n=5;
    //    String number = (n%2==0)?"even" : "odd";
    //    System.out.print("Given number is " + number);

    //switch

    // int btn = 3;
    // switch(btn){
    //     case 1 : 
    //         System.out.print("samosa");
    //           break;
    //     case 2 :
    //         System.out.print("burger");
    //          break;
    //     default:
    //         System.out.print("item not found");           
    // }

    // char op = sc.next().charAt(0);
    // int a = sc.nextInt();
    // int b = sc.nextInt();

    // switch(op){
    //     case '+':
    //         System.out.print(a+b);
    //          break;
    //     case '-':
    //         System.out.print(a-b);
    //          break;
    //     case '*':
    //         System.out.print(a*b);
    //          break;
    //     case '/':
    //         System.out.print(a/b);
    //          break; 
    //     case '%':
    //         System.out.print(a%b);
    //          break;
    //     default : 
    //         System.out.print("wrong operation");                         
    // }
    System.out.print("Enter year : ");
     Scanner sc = new Scanner(System.in);
    int year = sc.nextInt();

    if(year%4 == 0){
        if(year%100 == 0){
           if(year%400 == 0){
             System.out.print("it is leap a year!");
           }else{
             System.out.print("it is not a leap year!"); 
            }
        }else{
         System.out.print("it is a leap year!"); 
        }
    }else{
         System.out.print("it is not a leap year!"); 
    }

    }
}