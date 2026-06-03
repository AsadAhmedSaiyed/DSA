import java.util.*;

class WordLadder{
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int st = 1;
        while(!q.isEmpty()){
           int size = q.size();
           while(size > 0){
             size--;
             String word = q.remove();
             if(word.equals(endWord)) return st;
             for(int i=0;i<word.length();i++){
                for(char ch = 'a'; ch <= 'z';ch++){
                    char chars[] = word.toCharArray();
                    chars[i] = ch;
                    String newWord = new String(chars);
                    if(wordSet.contains(newWord)){
                        q.add(newWord);
                        wordSet.remove(newWord);
                    }
                }
             }
           }
           st++;
        }
        return 0;
    }
}