public class MinWindow{
    public String minWindow(String s, String t) {
        int min = Integer.MAX_VALUE;
        int l =0;
        int start = 0;
        int matches = 0;
        int need[] = new int[128];
        int window[] = new int[128];
        for(int i=0;i<t.length();i++){
            need[t.charAt(i)]++;
        }
        for(int i=0;i<s.length();i++){
           window[s.charAt(i)]++;
           if(window[s.charAt(i)] <= need[s.charAt(i)]){
             matches++;
           }
           while(matches == t.length()){
              if(i-l+1 < min){
                min = i-l+1;
                start = l; 
              }
              window[s.charAt(l)]--;
              if(window[s.charAt(l)] < need[s.charAt(l)]){
                matches--;
              }
              l++;
           }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start+min);
    }
}