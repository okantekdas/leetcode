package leetcode.linkedlist;

/* https://leetcode.com/problems/rotate-list */
/* Runtime: 0 ms, faster than 100.00% Memory Usage: 38.2 MB, less than 97.50% */
public class RotateList {
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

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = head;
        ListNode leftPrev = null;

        k--;

        int length = 0;
        for (int i = 0; i < k; i++) {
            if (right != null) {
                right = right.next;
                length++;
            } else {
                break;
            }
        }
        if (right == null) {
            right = head;
            if ((k + 1) % length == 0) {
                return head;
            }
            for (int j = 0; j < k % length; j++) {
                right = right.next;
            }
        } else if (right.next == null && length == k) {
            return head;
            // right = left;
        }

        while (right.next != null) {
            leftPrev = left;
            left = left.next;
            right = right.next;
        }

        leftPrev.next = null;

        right.next = head;

        return left;
    }

    static RotateList rl = new RotateList();

    public static void main(String[] args) {

        ListNode n0 = rl.new ListNode(0);
        ListNode n1 = rl.new ListNode(1);
        ListNode n2 = rl.new ListNode(2);

        n0.next = n1;
        n1.next = n2;

        rl.rotateRight(n0, 3);

    }

}
