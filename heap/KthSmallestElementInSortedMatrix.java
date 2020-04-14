package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/* https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/ */
public class KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (heap.size() < k) {
                    heap.add(matrix[i][j]);
                } else if (heap.size() == k && matrix[i][j] < heap.peek()) {
                    heap.poll();
                    heap.add(matrix[i][j]);
                }

            }
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        int nums[][] = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        int k = 8;

        System.out.println(new KthSmallestElementInSortedMatrix().kthSmallest(nums, k));
    }

}