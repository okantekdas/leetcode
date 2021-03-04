package leetcode.linkedlist;

import leetcode.linkedlist.SortList.ListNode;

/* https://leetcode.com/problems/intersection-of-two-linked-lists/submissions/ */
/* Runtime: 0 ms, faster than 100.00% Memory Usage: 41.4 MB, less than 97.54% */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode headACopy = headA;
        ListNode headBCopy = headB;

        while (headACopy != null && headBCopy != null) {
            headACopy = headACopy.next;
            headBCopy = headBCopy.next;
        }

        ListNode headToTrack = headACopy == null ? headBCopy : headACopy;
        ListNode headToDrag = headACopy == null ? headB : headA;
        ListNode headOriginal = headToDrag == headA ? headB : headA;

        while (headToTrack != null) {
            headToTrack = headToTrack.next;
            headToDrag = headToDrag.next;
        }

        while (headOriginal != headToDrag) {
            headOriginal = headOriginal.next;
            headToDrag = headToDrag.next;
        }
        return headToDrag;
    }
}
