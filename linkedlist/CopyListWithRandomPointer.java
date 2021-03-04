package leetcode.linkedlist;

import java.util.HashMap;

/* https://leetcode.com/problems/copy-list-with-random-pointer/ */
/* Runtime: 0 ms, faster than 100.00% */
public class CopyListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

    }

    public Node copyRandomList(Node head) {

        HashMap<Node, Node> nodeToNode = new HashMap<>();

        Node headPointer = head;

        while (head != null) {
            nodeToNode.put(head, new Node(head.val));
            head = head.next;

        }

        head = headPointer;

        while (head != null) {

            Node headCopy = nodeToNode.get(head);
            headCopy.next = nodeToNode.get(head.next);
            headCopy.random = nodeToNode.get(head.random);
            head = head.next;

        }

        return nodeToNode.get(headPointer);
    }

}
