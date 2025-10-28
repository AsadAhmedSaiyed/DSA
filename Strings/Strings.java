
import java.util.*;

public class Strings {
    public static void printString(String str){
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i));
        }
    }
    public static boolean isPalindrome(String str){
        int start = 0;
        int end = str.length()-1;
        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                //not a palindrome
                return false;
            } 
            start++;
            end--;  
        }
        return true;
    }
    public static void main(String[] args) {
        // char arr[] = {'a','b','c'};
        // String str = "abc"; 
        // String str2 = new String("xyz");
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

         String name;
         name = sc.nextLine();
         System.out.println(name);
         System.out.println(name.length());

        //concatenation
        String firstName = "asad";
        String middleName = "ahmed";
        String lastName = "saiyed";
        System.out.println(firstName + " " + middleName + " " + lastName);
         System.out.print(firstName.charAt(3));

        System.out.print(isPalindrome("asad"));
    }
}
