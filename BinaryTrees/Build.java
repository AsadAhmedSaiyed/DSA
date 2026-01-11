package BinaryTrees;

import java.util.*;

import javax.swing.tree.TreeNode;

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
