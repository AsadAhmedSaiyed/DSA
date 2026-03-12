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

        private boolean helper(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
        }

        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return helper(root.left, root.right);
        }
    }

    public static void main(String[] args) {

    }
}