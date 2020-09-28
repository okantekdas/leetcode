package leetcode.twopointers;

/* https://leetcode.com/problems/linked-list-cycle-ii */
public class LinkedListCycle2 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode left = head;
        ListNode right = head;
        ListNode left2 = head;

        while (right.next != null && right.next.next != null) {
            left = left.next;
            right = right.next.next;
            if (right == left) {
                while (left != left2) {
                    left2 = left2.next;
                    left = left.next;
                }
                return left2;
            }

        }
        return null;
    }

    static LinkedListCycle2 llc = new LinkedListCycle2();

    public static void main(String[] args) {
        ListNode node1 = llc.new ListNode(3);
        ListNode node2 = llc.new ListNode(2);
        ListNode node3 = llc.new ListNode(0);
        ListNode node4 = llc.new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(llc.detectCycle(node1).val);

    }
}