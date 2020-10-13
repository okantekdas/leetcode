package leetcode.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/sort-list */
public class SortList {

    static SortList sl = new SortList();

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
        }
    }

    /* Runtime: 3 ms, faster than 97.49% */
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return sort(left, right);
    }

    private ListNode sort(ListNode left, ListNode right) {

        ListNode head = new ListNode();
        ListNode tail = head;

        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;

            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;

        }

        tail.next = left != null ? left : right;
        return head.next;
    }

    private ListNode findMid(ListNode head) {

        ListNode left = head;
        ListNode right = head.next;
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }
        ListNode leftPrev = left;
        left = left.next;
        leftPrev.next = null;
        return left;
    }

    /*
     * Runtime: 9 ms Memory Usage: 42.9 MB
     */
    public ListNode sortListAlternate(ListNode head) {

        if (head == null) {
            return null;
        }

        List<Integer> nums = new ArrayList<>();

        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }

        Integer[] arr = (Integer[]) nums.toArray(new Integer[nums.size()]);
        heapSort(arr);

        int i = 0;
        ListNode currentNode = new ListNode(arr[i]);
        ListNode firstNode = currentNode;
        for (i = 0; i < nums.size(); i++) {

            ListNode nextNode = null;
            if (i + 1 < nums.size()) {
                nextNode = new ListNode(arr[i + 1]);
            }
            currentNode.next = nextNode;
            currentNode = nextNode;

        }
        return firstNode;

    }

    public void heapSort(Integer[] arr) {

        int length = arr.length;
        // heapify
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(arr, length, i);
        }
        // heap sort

        for (int i = length - 1; i >= 0; i--) {

            swap(arr, 0, i);
            heapify(arr, i, 0);
        }

    }

    public void heapify(Integer[] arr, int length, int rootIndex) {

        int maxIndex = rootIndex;
        int leftChildIndex = rootIndex * 2 + 1;
        int rightChildIndex = rootIndex * 2 + 2;

        if (leftChildIndex < length && arr[leftChildIndex] > arr[maxIndex]) {
            maxIndex = leftChildIndex;
        }

        if (rightChildIndex < length && arr[rightChildIndex] > arr[maxIndex]) {
            maxIndex = rightChildIndex;
        }

        if (maxIndex != rootIndex) {
            swap(arr, maxIndex, rootIndex);
            heapify(arr, length, maxIndex);
        }

    }

    public void swap(Integer[] arr, int index1, int index2) {

        int temp = arr[index1];

        arr[index1] = arr[index2];
        arr[index2] = temp;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            ListNode ret = new SortList().sortList(head);

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
        ListNode dummyRoot = sl.new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = sl.new ListNode(item);
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