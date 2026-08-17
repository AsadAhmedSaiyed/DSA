import java.util.Arrays;

public class Permutations {
     public boolean checkInclusion(String s1, String s2) {
        int need[] = new int[26];
        int window[] = new int[26];
        for(int i=0;i<s1.length();i++){
            need[s1.charAt(i)-'a']++;
        }
        int l = 0;
        for(int r=0;r<s2.length();r++){
           window[s2.charAt(r)-'a']++;
           while(r-l+1 > s1.length()){
             window[s2.charAt(l)-'a']--;
             l++;
           }
           if(Arrays.equals(need,window)){
             return true;
           }
        }
        return false;
    }
}
