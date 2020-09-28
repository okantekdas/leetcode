package leetcode.twopointers;

/* https://leetcode.com/problems/palindrome-linked-list/ */
public class PalindromeLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode h = head;
        ListNode slow = head;
        ListNode fast = head;

        int index = 0;
        while (fast != null) {
            if (index % 2 == 1) {
                slow = slow.next;
            }
            fast = fast.next;
            index++;
        }

        ListNode prev = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        while (prev != null) {
            if (h.val != prev.val) {
                return false;
            }
            h = h.next;
            prev = prev.next;
        }

        return true;
    }
}