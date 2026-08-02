import java.util.Stack;

public class ValidPArenthesis {
    //TC and SC - O(n)
    public boolean checkValidString(String s) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                s1.push(i);
            }
            else if(s.charAt(i) == '*'){
                s2.push(i);
            }else{
                if(!s1.isEmpty()){
                    s1.pop();
                }
                else if(!s2.isEmpty()){
                    s2.pop();
                }else{
                    return false;
                }
            }
        }
        while(!s1.isEmpty() && !s2.isEmpty()){
            int idx1 = s1.peek();
            int idx2 = s2.peek();
            if(idx2 > idx1){
                s1.pop();
                s2.pop();
            }else{
                break;
            }
        }
        return s1.isEmpty();
    }
    //TC - O(n) and SC - O(1)
     public boolean checkValidString2(String s) {
        int min = 0, max = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                min++;
                max++;
            }
            else if(s.charAt(i) == ')'){
                min--;
                max--;
            }else{
                min--;
                max++;
            }
            if(max < 0){
                return false;
            }
            if(min < 0){
                min = 0;
            }
        }
        return min == 0 ? true : false;
    }
}
