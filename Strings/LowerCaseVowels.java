import java.util.*;

public class LowerCaseVowels{
    @SuppressWarnings("StringEquality")
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u' ){
             count++;
            }
        }
        System.out.print(count);
        String arr = "1";
        String arr2 = "1";
        System.out.print(arr == arr2);
    }
}