package leetcode.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* https://leetcode.com/problems/odd-even-linked-list/ */
public class OddEvenLinkedList {

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

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode evenHead = null;
        ListNode evenEnd = null;
        ListNode oddHead = null;
        ListNode oddEnd = null;

        ListNode current = head;
        int i = 0;
        while (current != null) {
            if (i % 2 == 0) {
                if (evenEnd == null) {
                    evenHead = current;
                    evenEnd = current;
                } else {
                    evenEnd.next = current;
                    evenEnd = current;
                }
            } else {
                if (oddHead == null) {
                    oddHead = current;
                    oddEnd = current;
                } else {
                    oddEnd.next = current;
                    oddEnd = current;
                }
            }

            current = current.next;
            i++;
        }
        oddEnd.next = null;
        evenEnd.next = oddHead;

        return evenHead;

    }

    static OddEvenLinkedList oell = new OddEvenLinkedList();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            ListNode ret = oell.oddEvenList(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = oell.new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = oell.new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

}