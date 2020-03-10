package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * NaryTreeLevelOrderTraversal
 */
public class NaryTreeLevelOrderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int currentSize = queue.size();

            List<Integer> innerResult = new ArrayList<>();

            for (int i = 0; i < currentSize; i++) {

                Node currentNode = queue.poll();
                innerResult.add(currentNode.val);

                for (Node childNode : currentNode.children) {

                    queue.add(childNode);
                }

            }

            result.add(innerResult);

        }

        return result;

    }

    public static void main(String[] args) {

    }

}