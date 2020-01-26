package leetcode;

/**
 * FlattenBinaryTreeToLinkedList
 */

class Node {
    int val;
    Node left;
    Node right;

    Node(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
    }

}

public class FlattenBinaryTreeToLinkedList {

    public static Node flatten(Node root) {

        if (root == null) {
            return null;
        } else {
            Node resultLeft = flatten(root.left);

            Node resultRight = flatten(root.right);

            root.left = null;

            if (resultLeft != null) {
                root.right = resultLeft;
                if (resultRight != null) {
                    Node prev = null;
                    while (resultLeft != null) {
                        prev = resultLeft;
                        resultLeft = resultLeft.right;
                    }
                    prev.right = resultRight;
                }

            } else if (resultRight != null) {
                root.right = resultRight;
            }

            return root;

        }

    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.left = node2;
        node1.right = node5;

        node2.left = node3;
        node2.right = node4;

        node5.right = node6;

        Node treeNode = flatten(node1);

        System.out.println(treeNode);

    }
}