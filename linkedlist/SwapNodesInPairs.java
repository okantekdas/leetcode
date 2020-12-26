package leetcode.linkedlist;

/* https://leetcode.com/problems/swap-nodes-in-pairs/submissions/ */
/* Runtime: 0 ms, faster than 100.00% */
public class SwapNodesInPairs {

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

    public ListNode swapPairs(ListNode head) {

        ListNode headCopy = head;
        ListNode prevTail = null;
        while (head != null && head.next != null) {

            ListNode headCandidate = head.next;
            ListNode tailCandidate = head;
            head = head.next.next;
            tailCandidate.next = headCandidate.next;
            headCandidate.next = tailCandidate;
            if (prevTail != null) {
                prevTail.next = headCandidate;
            } else {
                headCopy = headCandidate;
            }
            prevTail = tailCandidate;
        }

        return headCopy;
    }

    static SwapNodesInPairs snip = new SwapNodesInPairs();

    public static void main(String[] args) {
        ListNode n1 = snip.new ListNode(1);
        // ListNode n2 = snip.new ListNode(2);
        // ListNode n3 = snip.new ListNode(3);
        // ListNode n4 = snip.new ListNode(4);

        // n1.next = n2;
        // n2.next = n3;
        // n3.next = n4;

        System.out.println(snip.swapPairs(n1));
    }
}
