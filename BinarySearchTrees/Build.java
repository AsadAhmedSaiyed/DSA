
public class Build {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root,int val){
        if(root == null){
            root = new Node(val);
            return root;
        } 
        if(root.data > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    } 
    public static void inOrder(Node root){

        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
        
    }
    
    public static Node searchBST(Node root, int val) {
        if(root == null){
            return null;
        }
        if(root.data == val){
            return root;
        }
        if(root.data < val){
            return searchBST(root.right,val);
        }else{
            return searchBST(root.left,val);
        }
    }
    
    private Node inOrderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    public Node deleteNode(Node root, int key) {
        if(root == null){
            return null;
        }
        if(root.data == key){
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            Node IS = inOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right,IS.data);
        }
        if(root.data<key){
            root.right = deleteNode(root.right,key);
        }else{
            root.left = deleteNode(root.left,key);
        }
        return root;
    }
    
    public int rangeSumBST(Node root, int low, int high) {
        if(root == null){
            return 0;
        }

        if(root.data < low){
            return rangeSumBST(root.right,low,high);
        }
        if(root.data > high){
            return rangeSumBST(root.left,low,high);
        }
        return root.data + rangeSumBST(root.left,low,high) + rangeSumBST(root.right,low,high);
    }
    public static void main(String[] args) {
        int val[] = {5,1,3,4,2,7};
        Node root =  null;
        for(int i=0;i<val.length;i++){
            root = insert(root, val[i]);
        }
        inOrder(root);

    }
}
