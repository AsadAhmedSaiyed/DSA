
public class PrefixTree {
    static class Node{
       Node children[] = new Node[26];
       boolean eof = false;
       Node(){
         for (int i = 0; i < children.length; i++) {
            children[i] = null;           
         }
       }
    }

    public static Node root = new Node();

    public static void insert(String word){
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

    public static boolean startsWith(String prefix) {
        Node curr = root;
        for(int i=0;i<prefix.length();i++){
            int idx = prefix.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static boolean search(String word){
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

    public static void main(String[] args) {
        String words[] = {"the", "a","there", "their","any","thee"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        System.out.println(search("thee"));
        System.out.println(search("thor"));
    }
}
