package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/* https://leetcode.com/problems/kth-largest-element-in-a-stream/submissions/ */
public class KthLargest {

    PriorityQueue<Integer> queue;

    int limit = 0;

    public KthLargest(int k, int[] nums) {
        limit = k;
        queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {

        if (queue.size() < limit) {
            queue.add(val);
        } else {
            if (queue.peek() < val) {
                if (queue.size() == limit) {
                    queue.poll();
                }
                queue.add(val);
            }
        }

        return queue.peek();

    }

    public static void main(String[] args) {

        int k = 2;
        int[] arr = { 0 };
        KthLargest kthLargest = new KthLargest(k, arr);
        kthLargest.add(-1); // returns 4
        kthLargest.add(1); // returns 5
        kthLargest.add(-2); // returns 5
        kthLargest.add(-4); // returns 8
        kthLargest.add(3); // returns 8
    }

}