package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/* 
Runtime: 0 ms, faster than 100.00% Memory Usage: 38.3 MB, less than 93.82%
Alternate: Runtime: 1 ms, faster than 50.73% Memory Usage: 38.5 MB, less than 85.03% */
public class PopulatingNextRightPointersInEachNode2 {

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node ref = root;
        while (root != null) {

            Node leftHead = root;
            while (root != null) {
                if (root.left != null) {
                    if (root.right != null) {
                        root.left.next = root.right;
                    } else {
                        Node temp = root;
                        while (temp.next != null) {
                            if (temp.next.left != null) {
                                root.left.next = temp.next.left;
                                break;
                            } else if (temp.next.right != null) {
                                root.left.next = temp.next.right;
                                break;
                            }
                            temp = temp.next;
                        }
                    }
                }
                if (root.right != null) {
                    Node temp = root;
                    while (temp.next != null) {
                        if (temp.next.left != null) {
                            root.right.next = temp.next.left;
                            break;
                        } else if (temp.next.right != null) {
                            root.right.next = temp.next.right;
                            break;
                        }
                        temp = temp.next;
                    }
                }
                root = root.next;
            }

            while (leftHead.left == null && leftHead.right == null) {
                leftHead = leftHead.next;
                if (leftHead == null) {
                    return ref;
                }
            }
            root = leftHead.left != null ? leftHead.left : leftHead.right;

        }
        return ref;
    }

    public Node connectAlternate(Node root) {

        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();

                if (i < size - 1) {
                    currentNode.next = queue.peek();
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left);

                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }

            }
        }
        return root;
    }

    static PopulatingNextRightPointersInEachNode2 p = new PopulatingNextRightPointersInEachNode2();

    public static void main(String[] args) {

        // Node node1 = p.new Node(1);
        // Node node2 = p.new Node(2);
        // Node node3 = p.new Node(3);
        // Node node4 = p.new Node(4);
        // Node node5 = p.new Node(5);
        // Node node6 = p.new Node(6);
        // Node node7 = p.new Node(7);
        // Node node8 = p.new Node(8);

        // node1.left = node2;
        // node1.right = node3;

        // node2.left = node4;
        // node2.right = node5;

        // node3.right = node6;

        // node4.left = node7;

        // node6.right = node8;

        Node node1 = p.new Node(1);
        Node node2 = p.new Node(2);
        Node node3 = p.new Node(3);
        Node node4 = p.new Node(4);
        Node node5 = p.new Node(5);
        Node node6 = p.new Node(6);
        Node node7 = p.new Node(7);
        Node node8 = p.new Node(8);

        node1.left = node2;
        node1.right = node3;

        node3.right = node4;
        node3.left = node5;

        node4.right = node6;

        node5.left = node7;

        System.out.println(p.connect(node1));
    }
}
