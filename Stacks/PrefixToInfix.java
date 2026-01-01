import java.util.Stack;

public class PrefixToInfix {
    public static String convert(String str){
        Stack<String> s = new Stack<>();
        int i=str.length()-1;
        while(i>=0){
            char ch = str.charAt(i);
            if(((ch >= 'A')&&(ch <= 'Z')) || (ch >= 'a' && ch <='z') || (ch >= 0 && ch <= 9)){
              s.push(String.valueOf(ch));
            }else{
                String t1 = s.pop();
                String t2 = s.pop();
                StringBuilder con = new StringBuilder();
                con.append("(");
                con.append(t1);
                con.append(String.valueOf(ch));
                con.append(t2);
                con.append(")");
                s.push(con.toString());
            }
            i--;
        }
        return s.peek();
    }
    public static void main(String[] args) {
        System.out.println(convert("/ab"));
    }
}
