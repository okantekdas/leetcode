package leetcode.search;

/* https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/ */
public class FlattenAMultilevelDoublyLinkedList {

    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }

    }

    public Node flatten(Node head) {

        Node root = head;

        while (head != null) {

            if (head.child != null) {
                Node child = flatten(head.child);

                Node oldNext = head.next;

                Node childEnd = child;
                while (childEnd.next != null) {
                    childEnd = childEnd.next;
                }
                head.child = null;
                head.next = child;
                child.prev = head;
                if (childEnd != null) {
                    childEnd.next = oldNext;
                }
                if (oldNext != null) {
                    oldNext.prev = childEnd;
                }

                head = oldNext;
            } else {
                head = head.next;
            }

        }

        return root;
    }

    static FlattenAMultilevelDoublyLinkedList f = new FlattenAMultilevelDoublyLinkedList();

    public static void main(String[] args) {

        Node node1 = f.new Node(1);
        Node node2 = f.new Node(2);
        Node node3 = f.new Node(3);
        Node node4 = f.new Node(4);
        Node node5 = f.new Node(5);
        Node node6 = f.new Node(6);
        Node node7 = f.new Node(7);
        Node node8 = f.new Node(8);
        Node node9 = f.new Node(9);
        Node node10 = f.new Node(10);
        Node node11 = f.new Node(11);
        Node node12 = f.new Node(12);

        node11.next = node12;

        node8.next = node9;
        node8.child = node11;
        node9.next = node10;

        node7.next = node8;

        node3.child = node7;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Node root = f.flatten(node1);

        int a = 5;

    }

}