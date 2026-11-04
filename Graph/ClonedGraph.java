public class ClonedGraph{

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> h;
    private void dfs(Node node, Node cloned,HashMap<Node, Node> h){
        for(Node neighbor : node.neighbors){
            if(!h.containsKey(neighbor)){
                Node clonedNeighbor = new Node(neighbor.val);
                h.put(neighbor , clonedNeighbor);

                cloned.neighbors.add(clonedNeighbor);
                dfs(neighbor, clonedNeighbor, h);
            }else{
                cloned.neighbors.add(h.get(neighbor));
            }
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        h = new HashMap<>();
        Node cloned = new Node(node.val);
        h.put(node, cloned);
        dfs(node, cloned, h);
        return cloned;
    }
}
}