// User function Template for Java

class PrefixProblem {
    private class Node{
       Node children[] = new Node[26];
       boolean eof = false;
       int freq;
       Node(){
         for (int i = 0; i < children.length; i++) {
            children[i] = null;           
         }
         freq = 1;
       }
    }

    private Node root = new Node();

    private void insert(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){// O(L)
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }else{
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eof = true;
    }
    
    private int search(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){// O(L)
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx].freq == 1){
                return i;
            }
            curr = curr.children[idx];
        }
        return word.length()-1;
    }
    
    public String[] findPrefixes(String[] arr, int N) {
        String ans[] = new String[N];
        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }
        root.freq = -1;
        for(int i=0;i<arr.length;i++){
            int end = search(arr[i]);
            String prefix = arr[i].substring(0, end+1);
            ans[i] = prefix;
        }
        return ans;
    }
};