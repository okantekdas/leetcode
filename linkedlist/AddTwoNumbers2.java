package leetcode.linkedlist;

import java.util.Stack;

/* https://leetcode.com/problems/add-two-numbers-ii/ */
/* Runtime: 4 ms, faster than 29.01% */
public class AddTwoNumbers2 {

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

        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();

        while (l1.next != null) {
            l1Stack.push(l1.val);
            l1 = l1.next;
        }
        l1Stack.push(l1.val);

        while (l2.next != null) {
            l2Stack.push(l2.val);
            l2 = l2.next;
        }
        l2Stack.push(l2.val);

        Stack<Integer> solutionStack = new Stack<>();

        int prevCarry = 0;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty()) {
            int first = 0;
            if (!l1Stack.isEmpty()) {
                first = l1Stack.pop();
            }

            int second = 0;
            if (!l2Stack.isEmpty()) {
                second = l2Stack.pop();
            }

            int sum = first + second + prevCarry;
            prevCarry = sum >= 10 ? 1 : 0;

            solutionStack.push(sum >= 10 ? sum - 10 : sum);
        }

        if (prevCarry > 0) {
            solutionStack.push(prevCarry);
        }

        ListNode s = new ListNode();
        ListNode head = s;
        while (!solutionStack.isEmpty()) {
            s.val = solutionStack.pop();
            if (solutionStack.isEmpty()) {
                break;
            }
            s.next = new ListNode();
            s = s.next;
        }

        return head;
    }

    static AddTwoNumbers2 addTwoNumbers2 = new AddTwoNumbers2();

    public static void main(String[] args) {
        ListNode l1 = addTwoNumbers2.new ListNode(7);
        l1.next = addTwoNumbers2.new ListNode(2);
        l1.next.next = addTwoNumbers2.new ListNode(4);
        l1.next.next.next = addTwoNumbers2.new ListNode(3);

        ListNode l2 = addTwoNumbers2.new ListNode(5);
        l2.next = addTwoNumbers2.new ListNode(6);
        l2.next.next = addTwoNumbers2.new ListNode(4);

        addTwoNumbers2.addTwoNumbers(l1, l2);

    }
}
