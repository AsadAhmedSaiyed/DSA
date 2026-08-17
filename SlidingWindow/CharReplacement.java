public class CharReplacement{
     public int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int start = 0;
        int maxFreq = 0;
        int max = 0;
        for(int end=0;end<s.length();end++){
        
            freq[s.charAt(end)-'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(end)-'A']);
        
            while(((end-start+1) - maxFreq) > k){
                freq[s.charAt(start)-'A']--;
                start++;
            }
            max = Math.max(max, (end-start+1));  

        }
        return max;
    }
}