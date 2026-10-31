
public class SerializeAndDeserializeBT {
 
public class Codec {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    
    private void helper1(TreeNode root, StringBuilder s){
        if(root == null){
            s.append("#,");
            return;
        }
        s.append(root.val);
        s.append(',');
        helper1(root.left, s);
        helper1(root.right, s);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder("");
        helper1(root, s);
        return s.toString();
    }
    int i = 0;
    private TreeNode helper2(String str[], int i[]){
        String s = str[i[0]++];
        if(s.equals("#")) return null;
        TreeNode root  = new TreeNode(Integer.parseInt(s));
        root.left = helper2(str, i);
        root.right = helper2(str, i);
        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String str[] = data.split(",");
        return helper2(str, new int[]{0});    
    }
}
}
