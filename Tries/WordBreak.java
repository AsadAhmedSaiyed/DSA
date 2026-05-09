import java.util.*;
class WordBreak {
    private class Node{
       Node children[] = new Node[26];
       boolean eof = false;
       Node(){
         for (int i = 0; i < children.length; i++) {
            children[i] = null;           
         }
       }
    }

    private Node root = new Node();

    private void insert(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){// O(L)
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eof = true;
    }

    private boolean search(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eof == true;
    }
    private boolean helper(String key){
        if(key.length() == 0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
            if(search(key.substring(0,i)) && helper(key.substring(i))){
                return true;
            }
        }
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        for(int i=0;i<wordDict.size();i++){
            insert(wordDict.get(i));
        }
        return helper(s);
    }
}