package leetcode.other;

/* https://leetcode.com/problems/reorder-list/ */
public class ReorderList {
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

    public void reorderList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode left = head;
        ListNode right = head;

        boolean isOdd = false;
        while (right.next != null && right.next.next != null) {
            left = left.next;
            right = right.next.next;
        }
        if (right.next == null) {
            isOdd = true;
        }

        reverseLinkedList(left.next);
        left.next = midHead;

        ListNode headCopy = null;
        right = left.next;
        left = head;

        while (right != null) {
            ListNode nextleft = left.next;
            ListNode nextRight = right.next;

            if (headCopy == null) {
                headCopy = left;
                headCopy.next = right;
                headCopy = headCopy.next;
            } else {
                headCopy.next = left;
                headCopy.next.next = right;
                headCopy = headCopy.next.next;
            }
            left = nextleft;
            right = nextRight;

        }
        if (isOdd) {
            left.next = null;
            headCopy.next = left;
        }

    }

    ListNode midHead = null;

    public ListNode reverseLinkedList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode reversed = reverseLinkedList(head.next);
        if (reversed == null) {
            midHead = head;
            return head;
        }
        head.next = null;
        reversed.next = head;

        return head;
    }

    static ReorderList rl = new ReorderList();

    public static void main(String[] args) {
        ListNode l1 = rl.new ListNode(1);
        ListNode l2 = rl.new ListNode(2);
        ListNode l3 = rl.new ListNode(3);
        ListNode l4 = rl.new ListNode(4);
        ListNode l5 = rl.new ListNode(5);
        ListNode l6 = rl.new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        rl.reorderList(l1);
    }

}