
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Rev{
    static class Node{
       int data;
       Node left;
       Node right;
       Node(int data){
          this.data = data;
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
        public void preOrder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
        public void levelOrder(Node root){
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
               Node currNode = q.remove();
               if(currNode == null){
                  System.out.println();
                  if(q.isEmpty()){
                    break;
                  }else{
                    q.add(null);
                  }
               }else{
                 System.err.print(currNode.data + " ");
                 if(currNode.left != null){
                    q.add(currNode.left);
                 }
                 if(currNode.right != null){
                    q.add(currNode.right);
                 }
               }
            }
        }
        private boolean  getPathh(Node root, ArrayList<Node> path, Node n){
           if(root == null){
             return false;
           }
           path.add(root);
           if(root.data == n.data){
             return true;
           }
           boolean left = getPathh(root.left, path, n);
           boolean right = getPathh(root.right, path, n);
           if(left || right){
            return true;
           }
           path.remove(path.size()-1);
           return false;  
        }

        public Node lca(Node root, Node p, Node q){
            ArrayList<Node> p1 = new ArrayList<>();
            ArrayList<Node> p2 = new ArrayList<>();
            getPathh(root, p2, q);
            getPathh(root, p1, p);
            int i=0;
            while(i < p1.size() && i < p2.size()){
                if(p1.get(i) != p2.get(i)){
                   break;
                }
                i++;
            } 
            return p1.get(i-1);
        }
        int answer = -1;
        private int helper(Node root, Node n, int k){
            if(root == null){
                return -1;
            }
            int left = helper(root.left, n, k);
            int right = helper(root.right, n, k);
            if(left == -1 && right == -1){
                return -1;
            }
            int max = Math.max(left, right);
            if((max+1) == k){
                answer = root.data;
            }
            return max+1;
            
        }
        public int anc(Node root,Node n, int k){
            helper(root,n,k);
            return answer;
        }
        public int transform(Node root){
            if(root == null){
                return 0;
            }
            int left = transform(root.left);
            int right = transform(root.right);
            int newData = root.data;
            int newLeft = root.left == null ? 0 : root.left.data;
            int newRight = root.right == null ? 0 : root.right.data;

            root.data = left + right + newLeft + newRight;
            return newData;
        }
    }
   public static void main(String[] args) {
       
   }   
}