package leetcode.linkedlist;

import leetcode.linkedlist.SortList.ListNode;

/* https://leetcode.com/problems/swapping-nodes-in-a-linked-list/ */
/* Runtime: 2 ms, faster than 99.89% Memory Usage: 64.7 MB, less than 85.67% */
public class SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {

        ListNode current = head;
        ListNode kThNode = null;
        ListNode lastToKthNode = null;
        int counter = 1;

        while (current != null) {
            if (counter == k) {
                kThNode = current;
                lastToKthNode = head;
                counter++;
            } else if (counter > k) {
                lastToKthNode = lastToKthNode.next;
            } else {
                counter++;
            }
            current = current.next;
        }

        int temp = lastToKthNode.val;
        lastToKthNode.val = kThNode.val;
        kThNode.val = temp;
        return head;
    }
}
