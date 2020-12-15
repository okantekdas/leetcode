package leetcode.arrays;

import java.util.Arrays;

/* https://leetcode.com/problems/squares-of-a-sorted-array/ */
/* Runtime: 2 ms, faster than 61.98% Memory Usage: 40.6 MB, less than 89.60% */
public class SquaresOfASortedArray {

    public int[] sortedSquares(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
            }
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        return nums;
    }

}
