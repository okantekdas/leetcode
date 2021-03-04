package leetcode.arrays;

/* https://leetcode.com/problems/shortest-unsorted-continuous-subarray/ */
/* Runtime: 1 ms, faster than 99.95% */
public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {

        int smallest = Integer.MAX_VALUE;
        boolean isDescending = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                // non ascending
                isDescending = true;

            }
            if (isDescending) {
                smallest = Math.min(smallest, nums[i]);
            }

        }

        int biggest = Integer.MIN_VALUE;
        boolean isAscending = false;
        for (int i = nums.length - 2; i > -1; i--) {
            if (nums[i] > nums[i + 1]) {
                // non descending
                isAscending = true;
            }
            if (isAscending) {
                biggest = Math.max(biggest, nums[i]);
            }
        }

        int left = 0;
        for (; left < nums.length; left++) {
            // compare to smallest
            if (smallest < nums[left]) {
                break;
            }
        }

        int right = nums.length - 1;
        for (; right > -1; right--) {
            // compare to biggest
            if (biggest > nums[right]) {
                break;
            }
        }

        return right - left < 0 ? 0 : right - left + 1;
    }
}