import java.util.*;
class WordSearch {
    private class Node{
       Node children[] = new Node[26];
       String word;
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
        curr.word = word;
    }
    private void explore(char[][] board, int i, int j, Node curr, ArrayList<String> ans){
        char ch = board[i][j];
        if(ch == '#' || curr.children[ch - 'a'] == null) return;
        curr = curr.children[ch - 'a'];
        if(curr.word != null){
            ans.add(curr.word);
            curr.word = null;
        }
        board[i][j] = '#';
        if(i>0) explore(board,i-1,j,curr,ans);
        if(j > 0) explore(board,i,j-1,curr,ans);
        if(i < board.length-1) explore(board,i+1,j,curr,ans);
        if(j < board[i].length-1) explore(board,i,j+1,curr,ans);
        board[i][j] = ch;
    }
    public List<String> findWords(char[][] board, String[] words) {
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                explore(board, i, j,root,ans);
            }
        }
        return ans;
    }
}