import java.util.*;

import javax.swing.tree.TreeNode;


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
    
    ArrayList<String> paths = new ArrayList<>();
    StringBuilder ans = new StringBuilder("");
    private void searchPaths(Node root){
        if(root == null){
            return;
        }
        int len = ans.length();
        ans.append(root.data);
        if(root.left == null && root.right == null){
           paths.add(ans.toString());
           ans.setLength(len); 
           return;
        }
        ans.append("->");
        searchPaths(root.left);
        searchPaths(root.right);
        ans.setLength(len);
    }
    public List<String> binaryTreePaths(Node root) {
        if(root == null){
            return paths;
        }
        searchPaths(root);
        return paths;
    }
    //108 lc
    
    private Node helper(int nums[], int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start+end)/2;
        Node root = new Node(nums[mid]);
        root.left = helper(nums,start,mid-1);
        root.right = helper(nums, mid+1, end);
        return root;
    }
    public Node sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    //leetcode 1382
    
    private void inOrder(ArrayList<Integer> arr,Node root){
        if(root == null){
            return;
        }
        inOrder(arr,root.left);
        arr.add(root.data);
        inOrder(arr,root.right);
    }
    private Node createBST(ArrayList<Integer> arr, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
    Node root = new Node(arr.get(mid));
        root.left = createBST(arr, start, mid-1);
        root.right = createBST(arr,mid+1, end);
        return root;
    }
    public Node balanceBST(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inOrder(arr,root);
        return createBST(arr,0,arr.size()-1);
    }

    //size of largest bst in btree
    static int maxSize = 0;
    static class Info{
        boolean isBST;
        int min,max;
        int size;
        public Info(boolean isBST, int min, int max, int size){
           this.isBST = isBST;
           this.min = min;
           this.max = max;
           this.size = size;
        }
    }
    private static Info helper(Node root){
        if(root == null){
            return new Info(true, Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        Info leftInfo = helper(root.left);
        Info rightInfo = helper(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min,rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max,rightInfo.max));
        if (!leftInfo.isBST || !rightInfo.isBST ||
            root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, min, max, size);
        }
        maxSize = Math.max(maxSize, size);
        return new Info(true, min, max, size);
    }
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        maxSize = 0; 
        helper(root);
        return maxSize;
    }

    //merge 2 bsts
    private void helper3(ArrayList<Integer> arr, Node root){
        if(root == null){
            return;
        }
        helper3(arr,root.left);
        arr.add(root.data);
        helper3(arr,root.right);
    }
    public ArrayList<Integer> merge(Node root1, Node root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        helper3(arr1,root1);
        helper3(arr2,root2);
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0;
        int j=0;
        while(i < arr1.size() && j < arr2.size()){
            int n = arr1.get(i);
            int m = arr2.get(j);
            if(n<m){
                ans.add(n);
                i++;
            }else{
                ans.add(m);
                j++;
            }
        }
        while(i < arr1.size()){
            int n = arr1.get(i);
            ans.add(n);
            i++;
        }
        while(j < arr2.size()){
            int m = arr2.get(j);
            ans.add(m);
            j++;
        }
        
        return ans;
    }
    //leetcode 1008 imp
    
    static int idx = 0;
    private TreeNode helper(int preorder[], int min, int max){
        if(idx == preorder.length || preorder[idx] <= min || preorder[idx] >= max){
            return null;
        }
        TreeNode root = new TreeNode(preorder[idx]);
        idx++;
        root.left = helper(preorder, min, root.val);
        root.right = helper(preorder, root.val, max);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
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
