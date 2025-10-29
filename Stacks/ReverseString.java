import java.util.Stack;

public class ReverseString {
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            s.push(ch);
        }
        StringBuilder res = new StringBuilder("");
        while(!s.isEmpty()){
            char ch = s.pop();
            res.append(ch);
        }
        return res.toString();
    }
    public static void main(String[] args) {
          String str = "abc";
          System.out.println(reverseString(str));
    }
}
