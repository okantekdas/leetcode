package leetcode.other;

public class ReverseLinkedList {
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

    ListNode root = null;

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        reverseListHelper(head);
        return root;
    }

    public ListNode reverseListHelper(ListNode head) {

        if (head.next == null) {
            root = head;
            return head;
        }

        ListNode reversed = reverseListHelper(head.next);
        head.next = null;
        reversed.next = head;

        return head;
    }

    static ReverseLinkedList rll = new ReverseLinkedList();

    public static void main(String[] args) {
        ListNode node1 = rll.new ListNode(1);
        ListNode node2 = rll.new ListNode(2);
        ListNode node3 = rll.new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        rll.reverseList(node1);

    }

}