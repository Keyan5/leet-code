/*
// Definition for a Node.
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
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        Map<Integer, Node> created = new HashMap<>();
        return cloneGraph(node, created);
    }

    private Node cloneGraph(Node node, Map<Integer, Node> created) {
        if(created.containsKey(node.val)) 
            return created.get(node.val);

        Node clone = new Node(node.val);
        created.put(node.val, clone);

        for(Node neighbor: node.neighbors) {
            Node clonedNeighbor = cloneGraph(neighbor, created);
            clone.neighbors.add(clonedNeighbor);
        }

        return clone;
    }

}