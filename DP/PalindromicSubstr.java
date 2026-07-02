public class PalindromicSubstr {
    private int expand(int i, int j, String s){
        int l = i;
        int r = j;
        int count = 0;
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
            count++;
        }
        return count;
    }
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for(int i=0;i<n;i++){
            int c1 = expand(i,i,s);
            int c2 = expand(i,i+1,s);
            count += (c1+c2);
        }
        return count;
    }
}
