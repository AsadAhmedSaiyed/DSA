package BinaryTrees;

import java.util.*;

public class Build {
   static class Node {
      int data;
      Node left;
      Node right;

      Node(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
      }
   }

   static class BTree {
      static int idx = -1;

      public Node buildTree(int nodes[]) {
         idx++;
         if (nodes[idx] == -1) {
            return null;
         }
         Node newNode = new Node(nodes[idx]);
         newNode.left = buildTree(nodes);
         newNode.right = buildTree(nodes);
         return newNode;
      }

      public void preOrder(Node root) {
         if (root == null) {
            return;
         }
         System.out.print(root.data + " ");
         preOrder(root.left);
         preOrder(root.right);
      }

      public void inOrder(Node root) {
         if (root == null) {
            return;
         }
         inOrder(root.left);
         System.out.print(root.data + " ");
         inOrder(root.right);
      }

      public void postOrder(Node root) {
         if (root == null) {
            return;
         }
         postOrder(root.left);
         postOrder(root.right);
         System.out.print(root.data + " ");
      }

      public void levelOrder(Node root) {
         if (root == null) {
            return;
         }
         Queue<Node> q = new LinkedList<>();
         q.add(root);
         q.add(null);
         while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
               System.out.println("");
               if (q.isEmpty()) {
                  break;
               } else {
                  q.add(null);
               }
            } else {
               System.out.print(currNode.data + " ");
               if (currNode.left != null) {
                  q.add(currNode.left);
               }
               if (currNode.right != null) {
                  q.add(currNode.right);
               }
            }

         }
      }

      public int height(Node root) {
         if (root == null) {
            return 0;
         }
         int lh = height(root.left);
         int rh = height(root.right);
         return (Math.max(rh, lh) + 1);
      }

      public int count(Node root) {
         if (root == null) {
            return 0;
         }
         int lc = count(root.left);
         int rc = count(root.right);
         return (1 + lc + rc);
      }

      public int sumBT(Node root) {
         if (root == null) {
            return 0;
         }
         return sumBT(root.right) + sumBT(root.left) + root.data;
      }

      public int diameterOfBinaryTree(Node root) {
         if (root == null) {
            return 0;
         }
         int ld = diameterOfBinaryTree(root.left);
         int rd = diameterOfBinaryTree(root.right);
         int lh = height(root.left);
         int rh = height(root.right);
         int self = lh + rh + 1;
         return Math.max(Math.max(ld, rd), self) - 1;
      }

      public boolean isIdentical(Node node, Node subRoot) {
         if (node == null && subRoot == null) {
            return true;
         } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
         }
         if (!isIdentical(node.left, subRoot.left)) {
            return false;
         }
         if (!isIdentical(node.right, subRoot.right)) {
            return false;
         }
         return true;
      }

      public boolean isSubTree(Node root, Node subRoot) {
         if (root == null) {
            return false;
         }
         if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
               return true;
            }
         }

         return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
      }

      static class Info {
         Node node;
         int hd;

         public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
         }
      }

      public void topView(Node root) {
         // level order
         Queue<Info> q = new LinkedList<>();
         HashMap<Integer, Node> map = new HashMap<>();
         int min = 0;
         int max = 0;
         q.add(new Info(root, 0));
         q.add(null);
         while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.node == null) {
               if (q.isEmpty()) {
                  break;
               } else {
                  q.add(null);
               }
            } else {
               if (!map.containsKey(curr.hd)) {
                  map.put(curr.hd, curr.node);
               }
               if (curr.node.left != null) {
                  q.add(new Info(curr.node.left, curr.hd - 1));
                  min = Math.min(min, curr.hd - 1);
               }
               if (curr.node.right != null) {
                  q.add(new Info(curr.node.right, curr.hd + 1));
                  max = Math.max(max, curr.hd + 1);
               }
            }

         }
         for (int i = min; i <= max; i++) {
            System.out.print(map.get(i) + " ");
         }
      }

      public void KthLevel(Node root, int level, int k) {
         if (root == null) {
            return;
         }
         if (level == k) {
            System.out.print(root.data + " ");
            return;
         }
         KthLevel(root.left, level + 1, k);
         KthLevel(root.right, level + 1, k);
      }

      private boolean getPath(Node root, ArrayList<Node> path, Node node) {
         if (root == null) {
            return false;
         }
         path.add(root);
         if (root.data == node.data) {
            return true;
         }
         boolean foundLeft = getPath(root.left, path, node);
         boolean foundRight = getPath(root.right, path, node);

         if (foundLeft || foundRight) {
            return true;
         }
         path.remove(path.size() - 1);
         return false;
      }

      public Node lowestCommonAncestor(Node root, Node p, Node q) {
         ArrayList<Node> path1 = new ArrayList<>();
         ArrayList<Node> path2 = new ArrayList<>();
         getPath(root, path1, p);
         getPath(root, path2, q);
         int i = 0;
         while (i < path1.size() && i < path2.size()) {
            if (path1.get(i) != path2.get(i)) {
               break;
            }
            i++;
         }
         return path1.get(i - 1);
      }

      public Node lca(Node root, Node p, Node q) {

         if (root == null || root == p || root == q) {
            return root;
         }
         Node left = lca(root.left, p, q);
         Node right = lca(root.right, p, q);
         if (right == null) {
            return left;
         }
         if (left == null) {
            return right;
         }
         return root;
      }

      private int dist(Node root, int x) {
         if (root == null) {
            return -1;
         }
         if (root.data == x) {
            return 0;
         }
         int left = dist(root.left, x);
         int right = dist(root.right, x);
         if (left == -1 && right == -1) {
            return -1;
         } else if (left == -1) {
            return right + 1;
         } else {
            return left + 1;
         }

      }

      public int findDist(Node root, int a, int b) {
         Node ancestor = lca(root, a, b);
         int left = dist(ancestor, a);
         int right = dist(ancestor, b);

         return left + right;

      }
   }

   public static void main(String[] args) {
      int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
      BTree tree = new BTree();
      Node root = tree.buildTree(nodes);
      System.out.println(root.data);
      tree.preOrder(root);
      System.out.println("");
      tree.inOrder(root);
      System.out.println("");
      tree.postOrder(root);
      System.out.println("");
      tree.levelOrder(root);
      System.out.println("");
      System.out.println(tree.height(root));
      System.out.println(tree.count(root));

   }
}
