package leetcode.heap;

import java.util.PriorityQueue;

/* https://leetcode.com/problems/merge-k-sorted-lists */
public class MergeKSortedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < lists.length; i++) {

            ListNode currentNode = lists[i];
            while (currentNode != null) {
                heap.add(currentNode.val);
                currentNode = currentNode.next;
            }

        }
        Integer solution = heap.poll();
        if (solution == null) {
            return null;
        }
        ListNode current = new ListNode(solution);
        ListNode head = current;
        while (!heap.isEmpty()) {
            Integer next = heap.poll();
            current.next = new ListNode(next);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        MergeKSortedList msl = new MergeKSortedList();

        ListNode[] lists = new ListNode[3];

        ListNode head = msl.new ListNode(1);
        lists[0] = head;
        ListNode current = head;
        current.next = msl.new ListNode(4);
        current = current.next;
        current.next = msl.new ListNode(5);

        head = msl.new ListNode(1);
        lists[1] = head;
        current = head;
        current.next = msl.new ListNode(3);
        current = current.next;
        current.next = msl.new ListNode(4);

        head = msl.new ListNode(2);
        lists[2] = head;
        current = head;
        current.next = msl.new ListNode(6);

        msl.mergeKLists(lists);

    }

}