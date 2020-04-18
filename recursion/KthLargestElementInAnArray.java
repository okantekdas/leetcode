package leetcode.recursion;

import java.util.PriorityQueue;

/* https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/ */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            if (heap.size() < k) {
                heap.add(num);
            } else if (heap.peek() < num) {
                heap.poll();
                heap.add(num);
            }
        }

        return heap.peek();
    }

    // 20 ms
    public int findKthLargestAlternate(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1, k);
        return nums[nums.length - k];
    }

    private void quickSort(int[] nums, int left, int right, int k) {

        if (left >= right) {
            return;
        }

        int pivotLocation = sortByPivot(nums, left, right);

        if (pivotLocation == nums.length - k) {
            return;
        }

        if (pivotLocation < nums.length - k) {
            quickSort(nums, pivotLocation + 1, right, k);
        } else {
            quickSort(nums, left, pivotLocation - 1, k);
        }

    }

    private int sortByPivot(int[] nums, int start, int end) {

        int pivot = end;
        int left = start - 1;
        int right = start;

        while (right <= end) {

            if (nums[right] < nums[pivot]) {
                left++;
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }

            right++;

        }
        left++;
        int temp = nums[left];
        nums[left] = nums[pivot];
        nums[pivot] = temp;

        return left;
    }

    public static void main(String[] args) {
        int[] nums = { 7, 6, 5, 4, 3, 2, 1 };

        int k = 5;

        System.out.println(new KthLargestElementInAnArray().findKthLargest(nums, k));
    }

}