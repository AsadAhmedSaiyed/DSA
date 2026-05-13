class LongestWordWithAllPrefixes {
    class Node{
       Node children[] = new Node[26];
       boolean eof = false;
       Node(){
         for (int i = 0; i < children.length; i++) {
            children[i] = null;           
         }
       }
    }

    public  Node root = new Node();

    public  void insert(String word){
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
    public String ans = "";
    void helper(Node curr, StringBuilder temp){
        if(curr == null) return;
        for(int i=0;i<curr.children.length;i++){
            if(curr.children[i] != null && curr.children[i].eof == true){
                char ch = (char)(i+'a');
                temp.append(ch);
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                helper(curr.children[i],temp);
                temp.deleteCharAt(temp.length()-1);
            }
            
        }
    }
    public String longestValidWord(String[] words) {
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        helper(root,new StringBuilder(""));
        return ans;
    }
}
