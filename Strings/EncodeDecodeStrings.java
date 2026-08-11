import java.util.*;
public class EncodeDecodeStrings{
    public String encode(List<String> strs) {
        StringBuilder e = new StringBuilder("");
        for(int i=0;i<strs.size();i++){
            int n = strs.get(i).length();
            e.append(n);
            e.append('#');
            e.append(strs.get(i)); 
        }
        return e.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int n = Integer.parseInt(str.substring(i,j));
            j++;
            ans.add(str.substring(j,j+n));
            i = j+n;
        }
        return ans;
    }
}