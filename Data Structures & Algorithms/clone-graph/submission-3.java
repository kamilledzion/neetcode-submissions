/*
Definition for a Node.
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
        if (node == null) {
            return null;
        }

        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(node);
        
        Map<Integer, Node> visited = new HashMap<>();
        visited.put(node.val, new Node(node.val));
        
        while (!queue.isEmpty()) {
            var size = queue.size();

            for (int i = 0; i < size; i++) {
                Node n = queue.pollFirst();
                Node copy = visited.get(n.val);
                
                for (Node nei : n.neighbors) {
                    if (visited.containsKey(nei.val)) {
                        copy.neighbors.add(visited.get(nei.val));
                    } else {
                        queue.addLast(nei);

                        var newNei = new Node(nei.val);
                        copy.neighbors.addLast(newNei);
                        visited.put(nei.val, newNei);
                    }
                }
            }
        }
        return visited.get(node.val);
    }
}