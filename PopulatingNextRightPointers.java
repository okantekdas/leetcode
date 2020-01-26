package leetcode;

import java.util.LinkedList;
import java.util.List;

class Node {
    public String val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(String _val) {
        val = _val;
    }

    public Node(String _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

}

/**
 * PopulatingNextRightPointers
 */
public class PopulatingNextRightPointers {

    public static Node connect(Node root) {
        if (root != null) {
            List<Node> list = new LinkedList<>();
            list.add(root);
            root.next = null;

            Node previous = null;
            int i = 0;
            int level = 0;
            while (list.get(i) != null) {
                Node currentNode = list.get(i);
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

    public static void main(String[] args) throws InterruptedException {

        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");
        Node node6 = new Node("6");
        Node node7 = new Node("7");

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        connect(node1);

        int a = 5;

    }

}