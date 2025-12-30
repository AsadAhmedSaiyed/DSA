import java.util.Stack;

public class InfixToPostfiz {
    public static int priority(char ch){
        return switch (ch) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '-', '+' -> 1;
            default -> -1;
        };
    }
    public static String convert(String str){
      Stack<Character> s = new Stack<>();
      int i=0;
      StringBuilder ans = new StringBuilder();
      while(i<str.length()){
        char ch = str.charAt(i);
        if(((ch >= 'A')&&(ch <= 'Z')) || (ch >= 'a' && ch <='z') || (ch >= 0 && ch <= 9)){
           ans.append(ch);
        }else if(ch == '('){
          s.push(ch);
        }else if(ch == ')'){
            while(!s.isEmpty() && s.peek() != '('){
                ans.append(s.pop());
            }
            s.pop();
        }else{
            while(!s.isEmpty() && (priority(ch) <= priority(s.peek()))){
                ans.append(s.pop());
            }
            s.push(ch);
        }
        i++;
      }
      while(!s.isEmpty()){
         ans.append(s.pop());
      }
      return ans.toString();
    }
    public static void main(String[] args) {
        String e = "(a+b)*c-d+f";
        System.out.println(convert(e));
    }
}
