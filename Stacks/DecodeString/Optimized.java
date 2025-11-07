package DecodeString;

import java.util.Stack;

public class Optimized {
    public String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<StringBuilder> str = new Stack<>();
        StringBuilder newStr = new StringBuilder("");
        int k=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                 k = k*10 + (ch-'0');  
            }else if(ch == '['){
                num.push(k);
                k=0;
                str.push(newStr);
                newStr = new StringBuilder("");
            }else if(ch == ']'){
                int n = num.pop();
                StringBuilder temp = newStr;
                newStr = str.pop();
                while(n>0){
                    newStr.append(temp);
                    n--;
                }
            }else{
                newStr.append(ch);
            }
        }
        return newStr.toString();
    }
}
