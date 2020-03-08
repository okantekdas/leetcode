package leetcode.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * InsertionSortList
 */
public class InsertionSortList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {

        ListNode currentNode = head;
        ListNode prevNode = null;
        while (currentNode != null) {

            ListNode iteratorNode = null;

            if (prevNode != null && prevNode.val < currentNode.val) {
                iteratorNode = prevNode;
            } else {
                iteratorNode = head;
            }
            ListNode prevIteratorNode = null;
            while (iteratorNode != currentNode) {
                if (currentNode.val < iteratorNode.val) {
                    if (prevIteratorNode != null) {
                        prevIteratorNode.next = currentNode;
                    }
                    if (prevNode != null) {
                        prevNode.next = currentNode.next;
                    }
                    if (iteratorNode == head) {
                        head = currentNode;
                    }

                    currentNode.next = iteratorNode;
                    currentNode = iteratorNode;
                    break;

                }
                prevIteratorNode = iteratorNode;
                iteratorNode = iteratorNode.next;

            }

            prevNode = currentNode;
            currentNode = currentNode.next;

        }

        return head;

    }

    static InsertionSortList isl = new InsertionSortList();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            ListNode ret = new InsertionSortList().insertionSortList(head);

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
        ListNode dummyRoot = isl.new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = isl.new ListNode(item);
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