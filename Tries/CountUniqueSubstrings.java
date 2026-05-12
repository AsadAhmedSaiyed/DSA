class CountUniqueSubstrings {
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

  
    public int countSubs(String s) {
       int count = 0;    
       for(int i=0;i<s.length();i++){
           Node curr = root;
           for(int j=i;j<s.length();j++){
               int idx = s.charAt(j) - 'a';
               if(curr.children[idx] == null){
                curr.children[idx] = new Node();
                count++;
               }
               curr = curr.children[idx];
           }
       }
       return count;
    }
}