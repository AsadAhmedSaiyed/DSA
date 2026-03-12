import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Revision {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int data) {
            this.val = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BTree {
        static int idx = -1;

        public static Node build(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = build(nodes);
            newNode.right = build(nodes);
            return newNode;
        }

        public boolean isUnivalTree(Node root) {
            if (root == null) {
                return true;
            }
            if (root.left != null && root.val != root.left.val) {
                return false;
            }
            if (root.right != null && root.val != root.right.val) {
                return false;
            }
            boolean foundLeft = isUnivalTree(root.left);
            boolean foundRight = isUnivalTree(root.right);
            if (foundLeft && foundRight) {
                return true;
            }
            return false;
        }

        int sum = Integer.MIN_VALUE;

        private int helper(Node root) {
            if (root == null) {
                return 0;
            }
            int leftSum = Math.max(helper(root.left), 0);
            int rightSum = Math.max(helper(root.right), 0);
            int pathSum = root.val + leftSum + rightSum;
            sum = Math.max(sum, pathSum);

            return root.val + Math.max(leftSum, rightSum);
        }

        public int maxPathSum(Node root) {
            helper(root);
            return sum;
        }

        // leetcode 100
        private boolean helper1(Node left, Node right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            return left.val == right.val && helper1(left.left, right.right) && helper1(left.right, right.left);
        }

        public boolean isSymmetric(Node root) {
            if (root == null) {
                return true;
            }
            return helper1(root.left, root.right);
        }

        // leetcode 1325
        public Node removeLeafNodes(Node root, int target) {
            if (root == null) {
                return null;
            }
            root.left = removeLeafNodes(root.left, target);
            root.right = removeLeafNodes(root.right, target);
            if (root.val == target && root.left == null && root.right == null) {
                return null;
            } else {
                return root;
            }
        }
    //leetcode 625    
    HashMap<String,Integer> m = new HashMap<>();
    ArrayList<Node> ans = new ArrayList<>();
    private String helper2(Node root){
        if(root == null){
            return "N";
        }
        String left = helper2(root.left);
        String right = helper2(root.right);
        String tree = root.val + "," + left + "," + right;
        m.put(tree,m.getOrDefault(tree,0)+1);
        if(m.get(tree) == 2){
            ans.add(root);
        }
        return tree;
    }
    public List<Node> findDuplicateSubtrees(Node root) {
        helper2(root);
        return ans;
    }
    }

    public static void main(String[] args) {

    }
}