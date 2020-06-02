package leetcode.other;

/* https://leetcode.com/problems/delete-node-in-a-linked-list/ */
public class DeleteNodeInLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        node.val = node.next.val;
        if (node.next.next == null) {
            node.next = null;
        }
        deleteNode(node.next);
    }
}