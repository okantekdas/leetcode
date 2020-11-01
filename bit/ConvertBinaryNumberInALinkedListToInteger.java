package leetcode.bit;

/* https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/ */
/* Runtime: 0 ms, faster than 100.00% */
public class ConvertBinaryNumberInALinkedListToInteger {

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

    public int getDecimalValue(ListNode head) {
        int value = 0;
        while (head != null) {
            value += head.val;
            head = head.next;
            if (head != null) {
                value = value << 1;
            }
        }
        return value;
    }
}
