class WordDictionary {
    private class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        public Node(){
            for(int i=0;i<children.length;i++){
                children[i] = null;
            }
        }
    }
    private Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true; 
    }
 
    private boolean searchHelper(String word, Node curr) {
        for(int i=0;i<word.length();i++){
            if(word.charAt(i) == '.'){
                for(int j=0;j<curr.children.length;j++){
                    if(curr.children[j] != null && searchHelper(word.substring(i+1), curr.children[j])){
                        return true;
                    }
                }
                return false;
            }else{
                int idx = word.charAt(i) - 'a';
                if(curr.children[idx] == null){
                 return false;
                }
                curr = curr.children[idx];
            }
        }
        return curr.eow == true;
    } 

    public boolean search(String word){
       return searchHelper(word,root);
    }
    
}

