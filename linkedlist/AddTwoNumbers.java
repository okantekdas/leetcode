package leetcode.linkedlist;

/* https://leetcode.com/problems/add-two-numbers/ */
/* Runtime: 2 ms, faster than 77.07% Memory Usage: 39.2 MB, less than 70.77% */
public class AddTwoNumbers {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l1Start = l1;
        ListNode l2Start = l2;

        ListNode l1Prev = null;
        ListNode l2Prev = null;

        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            if (carry > 0) {
                sum -= 10;
            }
            l1.val = sum;
            l2.val = sum;
            l1Prev = l1;
            l2Prev = l2;
            l1 = l1.next;
            l2 = l2.next;

        }

        ListNode list = null;
        ListNode start = null;
        ListNode prev = null;
        if (l1 == null) {
            if (l2 == null) {
                if (carry > 0) {
                    l2Prev.next = new ListNode(carry);
                }
                return l2Start;
            } else {
                list = l2;
                start = l2Start;
                prev = l2Prev;
            }
        } else {
            list = l1;
            start = l1Start;
            prev = l1Prev;
        }

        while (list != null) {
            int sum = list.val + carry;
            carry = sum / 10;
            if (carry > 0) {
                sum -= 10;
            }
            list.val = sum;
            prev = list;
            list = list.next;
        }

        if (carry > 0) {
            prev.next = new ListNode(carry);
        }
        return start;
    }

    static AddTwoNumbers atn = new AddTwoNumbers();

    public static void main(String[] args) {
        ListNode l11 = atn.new ListNode(9);
        ListNode l12 = atn.new ListNode(9);
        ListNode l13 = atn.new ListNode(9);
        ListNode l14 = atn.new ListNode(9);
        ListNode l15 = atn.new ListNode(9);
        ListNode l16 = atn.new ListNode(9);
        ListNode l17 = atn.new ListNode(9);

        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;
        l16.next = l17;

        ListNode l21 = atn.new ListNode(9);
        ListNode l22 = atn.new ListNode(9);
        ListNode l23 = atn.new ListNode(9);
        ListNode l24 = atn.new ListNode(9);

        l21.next = l22;
        l22.next = l23;
        l23.next = l24;

        atn.addTwoNumbers(l11, l21);

    }
}