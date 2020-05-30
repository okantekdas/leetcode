package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* https://leetcode.com/problems/clone-graph/ */
public class CloneGraph {

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

    HashMap<Integer, Node> valToNode = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null) {

            return null;
        }

        Node cloneNode = new Node(node.val, new ArrayList<>());
        valToNode.put(node.val, cloneNode);
        for (Node neighbor : node.neighbors) {
            if (!valToNode.containsKey(neighbor.val)) {
                cloneNode.neighbors.add(cloneGraph(neighbor));
            } else {
                cloneNode.neighbors.add(valToNode.get(neighbor.val));
            }
        }

        return cloneNode;
    }
}