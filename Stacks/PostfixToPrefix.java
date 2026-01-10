import java.util.*;

public class PostfixToPrefix {
    public static String convert(String str){
        Stack<String> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            StringBuilder newstr = new StringBuilder();
            if(((ch >= 'A')&&(ch <= 'Z')) || (ch >= 'a' && ch <='z') || (ch >= 0 && ch <= 9)){
                s.push(String.valueOf(ch));
            }else{
                String t1 = s.pop();
                String t2 = s.pop();
                newstr.append(ch);
                newstr.append(t2);
                newstr.append(t1);
                s.push(newstr.toString());
            }
        }
        return s.pop();
    }
    public static void main(String[] args) {
        System.out.println(convert("AB-DE+F*/"));
    }
}
