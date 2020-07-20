package leetcode.other;

/* https://leetcode.com/problems/remove-linked-list-elements/ */
public class RemoveLinkedListElements {
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

    public ListNode removeElements(ListNode head, int val) {

        ListNode root = head;
        ListNode prev = null;
        while (head != null) {
            if (head.val != val) {
                prev = head;
                head = head.next;
            } else {
                if (prev == null) {
                    head = head.next;
                    root = head;
                } else {
                    head = head.next;
                    prev.next = head;
                }
            }
        }
        return root;
    }
}