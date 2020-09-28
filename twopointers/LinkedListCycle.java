package leetcode.twopointers;

/* https://leetcode.com/problems/linked-list-cycle/ */
public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode left = head;
        ListNode right = head.next;

        while (right != null) {
            if (left == right) {
                return true;
            }
            left = left.next;
            if (right.next == null || right.next.next == null) {
                return false;
            }
            right = right.next.next;

        }

        return false;

    }

}