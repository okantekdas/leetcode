package leetcode.arrays;

import java.util.Arrays;

/* https://leetcode.com/problems/next-permutation/ */
/* Runtime: 0 ms, faster than 100.00% Memory Usage: 38.9 MB, less than 93.45% */
public class NextPermutation {
    public void nextPermutation(int[] nums) {

        int index = nums.length - 1;

        while (index - 1 >= 0) {
            if (nums[index] <= nums[index - 1]) {
                index--;
            } else {
                int indexRight = nums.length - 1;

                while (indexRight > index - 1) {
                    if (nums[indexRight] > nums[index - 1]) {
                        // swap
                        int temp = nums[index - 1];
                        nums[index - 1] = nums[indexRight];
                        nums[indexRight] = temp;
                        break;
                    } else {
                        indexRight--;
                    }
                }
                break;
            }
        }

        reverse(nums, index);

    }

    private void reverse(int[] nums, int from) {

        int to = nums.length - 1;
        while (from < to) {
            int temp = nums[from];
            nums[from] = nums[to];
            nums[to] = temp;
            from++;
            to--;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 5, 1, 1 };

        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
