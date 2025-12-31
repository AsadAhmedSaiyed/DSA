import java.util.*;

public class InfixToPrefix {
    public static int priority(char ch){
        return switch (ch) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '-', '+' -> 1;
            default -> -1;
        };
    }
    public static String reverse(String str){
        char arr[] = str.toCharArray();
        int left =0;
        int right = str.length()-1;
        while(left < right){
            char temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }
        String newStr = new String(arr);
        return newStr;
    }
    public static String convert(String str){
        Stack<Character> s = new Stack<>();
        str = reverse(str);
        StringBuilder newStr = new StringBuilder();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '('){
              newStr.append(')');
            }else if(ch == ')'){
                newStr.append('(');
            }else{
                newStr.append(ch);
            }
        }
        str = newStr.toString();
        int i=0;
        StringBuilder ans = new StringBuilder();
        while (i<str.length()) {
            char ch = str.charAt(i);
            if(((ch >= 'A')&&(ch <= 'Z')) || (ch >= 'a' && ch <='z') || (ch >= '0' && ch <= '9')){
             ans.append(ch);
            }else if(ch == '('){
             s.push(ch);
            }else if(ch == ')'){
              while(!s.isEmpty() && s.peek() != '('){
                 ans.append(s.pop());
                }
                if (!s.isEmpty()) {
                    s.pop();
                }
            }else{
                while(!s.isEmpty() && (priority(ch) <priority(s.peek()))){
                 ans.append(s.pop());
                }
                s.push(ch);
            }
            i++;
        }
        while(!s.isEmpty()){
         ans.append(s.pop());
      }
      return reverse(ans.toString());

    }

    public static void main(String[] args) {
        String infix = "(A-B/C)*(A/K-L)";
        System.out.println(convert(infix));
    }
}