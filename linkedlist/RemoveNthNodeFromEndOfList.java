package leetcode.linkedlist;

import leetcode.linkedlist.RemoveDuplicatesFromSortedList2.ListNode;

/* Runtime: 0 ms, faster than 100.00% Memory Usage: 36.8 MB, less than 66.08% */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode leftPrev = null;
        ListNode left = head;
        ListNode leftNext = head.next;
        ListNode right = head;

        int counter = 1;
        while (right != null) {
            if (counter > n) {
                leftPrev = left;
                left = leftNext;
                leftNext = leftNext.next;
            } else {
                counter++;
            }
            right = right.next;
        }

        if (leftPrev != null) {
            leftPrev.next = leftNext;
        } else {
            head = left.next;
        }

        return head;
    }

    static RemoveDuplicatesFromSortedList2 rd = new RemoveDuplicatesFromSortedList2();

    public static void main(String[] args) {
        ListNode node1 = rd.new ListNode(1);
        ListNode node2 = rd.new ListNode(2);
        // ListNode node3 = rd.new ListNode(3);
        // ListNode node4 = rd.new ListNode(4);
        // ListNode node5 = rd.new ListNode(5);
        node1.next = node2;
        // node2.next = node3;
        // node3.next = node4;
        // node4.next = node5;

        new RemoveNthNodeFromEndOfList().removeNthFromEnd(node1, 2);
    }
}
