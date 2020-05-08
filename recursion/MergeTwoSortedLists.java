package leetcode.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* https://leetcode.com/problems/merge-two-sorted-lists/ */
public class MergeTwoSortedLists {

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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /* Runtime: 0 ms Memory Usage: 38.9 MB, less than 19.53% */
    public ListNode mergeTwoListsAlternate(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode subsolution = mergeTwoListsAlternate(l1 != null ? l1.next : null, l2 != null ? l2.next : null);

        if (l1 == null) {
            subsolution = l2;
        } else if (l2 == null) {
            subsolution = l1;
        } else {
            if (subsolution == null) {

                if (l1.val < l2.val) {
                    subsolution = l1;
                    subsolution.next = l2;
                } else {
                    subsolution = l2;
                    subsolution.next = l1;
                }
            } else {
                ListNode copySubsolution = subsolution;
                ListNode prev = null;
                while (copySubsolution != null && l1.val > copySubsolution.val) {
                    prev = copySubsolution;
                    copySubsolution = copySubsolution.next;
                }
                if (prev == null) {
                    l1.next = subsolution;
                    subsolution = l1;
                } else {
                    prev.next = l1;
                    l1.next = copySubsolution;
                }

                copySubsolution = subsolution;
                prev = null;
                while (copySubsolution != null && l2.val > copySubsolution.val) {
                    prev = copySubsolution;
                    copySubsolution = copySubsolution.next;
                }
                if (prev == null) {
                    l2.next = subsolution;
                    subsolution = l2;
                } else {
                    prev.next = l2;
                    l2.next = copySubsolution;
                }
            }
        }
        return subsolution;
    }

    static MergeTwoSortedLists mtsl = new MergeTwoSortedLists();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);

            ListNode ret = mtsl.mergeTwoLists(l1, l2);

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
        ListNode dummyRoot = mtsl.new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = mtsl.new ListNode(item);
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