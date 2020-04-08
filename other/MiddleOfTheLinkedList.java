package leetcode.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MiddleOfTheLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode(ListNode head) {

        ListNode front = head;
        ListNode rear = head;

        int iteration = 1;
        while (front != null) {
            front = front.next;
            if (iteration % 2 == 0) {
                rear = rear.next;
            }
            iteration++;
        }

        return rear;
    }

    static MiddleOfTheLinkedList motll = new MiddleOfTheLinkedList();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            ListNode ret = new MiddleOfTheLinkedList().middleNode(head);

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
        ListNode dummyRoot = motll.new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = motll.new ListNode(item);
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