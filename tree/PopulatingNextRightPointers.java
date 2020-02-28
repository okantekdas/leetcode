package leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * PopulatingNextRightPointers
 */
public class PopulatingNextRightPointers {
    class Node {
        public String val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(final String _val) {
            val = _val;
        }

        public Node(final String _val, final Node _left, final Node _right, final Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

    }

    public static Node connect(final Node root) {
        if (root != null) {
            final List<Node> list = new LinkedList<>();
            list.add(root);
            root.next = null;

            Node previous = null;
            int i = 0;
            int level = 0;
            while (list.get(i) != null) {
                final Node currentNode = list.get(i);
                if (previous != null) {
                    previous.next = currentNode;
                }

                System.out.println("level: " + level + " i: " + i + " currentValue: " + currentNode.val);

                if (Math.pow(2, level + 1) == i + 2) {
                    currentNode.next = null;
                    previous = null;
                    level++;
                } else {
                    previous = currentNode;
                }

                list.add(currentNode.left);
                list.add(currentNode.right);

                i++;

            }
        }

        return root;
    }

    public static void main(final String[] args) throws InterruptedException {

        PopulatingNextRightPointers pnrp = new PopulatingNextRightPointers();

        final Node node1 = pnrp.new Node("1");
        final Node node2 = pnrp.new Node("2");
        final Node node3 = pnrp.new Node("3");
        final Node node4 = pnrp.new Node("4");
        final Node node5 = pnrp.new Node("5");
        final Node node6 = pnrp.new Node("6");
        final Node node7 = pnrp.new Node("7");

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        connect(node1);

        final int a = 5;

    }

}