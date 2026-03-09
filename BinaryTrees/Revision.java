
public class Revision{
    static class Node{
       int val;
       Node left;
       Node right;
       Node(int data){
          this.val = data;
          this.left = null;
          this.right = null;
       }
    }
    static class BTree{
        static int idx = -1;
        public static Node build(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = build(nodes);
            newNode.right = build(nodes);
            return newNode;
        }
       public boolean isUnivalTree(Node root) {
        if(root == null){
            return true;
        }
        if(root.left != null && root.val != root.left.val){
            return false;
        }
        if(root.right != null && root.val != root.right.val){
            return false;
        }
        boolean foundLeft = isUnivalTree(root.left);
        boolean foundRight = isUnivalTree(root.right);
        if(foundLeft && foundRight){
            return true;
        }
        return false;
    }
    }
   public static void main(String[] args) {
       
   }   
}