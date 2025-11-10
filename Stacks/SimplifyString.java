import java.util.*;

class SimplifyString {
    public String simplifyPath(String path) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder("");
        for(int i=0;i<path.length();i++){
            if(path.charAt(i) != '/'){
                str.append(path.charAt(i));
            }else{
                if(str.length() > 0){
                   list.add(str.toString());
                }
                str = new StringBuilder("");
            }
        }
        if(str.length() > 0){
                   list.add(str.toString());
                }
        Stack<String> s = new Stack<>();
        StringBuilder newStr = new StringBuilder("");
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals(".")){
                continue;
            }else if(list.get(i).equals("..")){
                if(!s.isEmpty()){
                    s.pop();
                }
            }else{
                s.push(list.get(i));
            }
        }
        while(!s.isEmpty()){
            newStr.insert(0,"/"+s.pop());
        }
        return newStr.length() == 0 ? "/" : newStr.toString();
    }
}