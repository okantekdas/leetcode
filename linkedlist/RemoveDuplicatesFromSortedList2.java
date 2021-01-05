package leetcode.linkedlist;

/* https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/ */
/* Runtime: 0 ms, faster than 100.00% */
public class RemoveDuplicatesFromSortedList2 {

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

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode copyHead = new ListNode(-1, head);
        ListNode prev = copyHead;
        while (head != null) {

            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }

        return copyHead.next;
    }

    static RemoveDuplicatesFromSortedList2 rd = new RemoveDuplicatesFromSortedList2();

    public static void main(String[] args) {
        ListNode node0 = rd.new ListNode(1);
        ListNode node1 = rd.new ListNode(1);
        // ListNode node2 = rd.new ListNode(2);
        ListNode node3 = rd.new ListNode(3);
        ListNode node4 = rd.new ListNode(3);
        ListNode node5 = rd.new ListNode(4);
        ListNode node6 = rd.new ListNode(4);
        // ListNode node7 = rd.new ListNode(5);

        node0.next = node1;
        node1.next = node3;
        // node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        // node6.next = node7;

        rd.deleteDuplicates(node0);

    }
}
