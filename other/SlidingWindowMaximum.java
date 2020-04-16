package leetcode.other;

import java.util.Arrays;

/* https://leetcode.com/problems/sliding-window-maximum/ */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] solution = new int[nums.length - k + 1];

        int left = 0;
        int right = 0;
        int localMax = Integer.MIN_VALUE;
        int prevMaxIndex = -1;
        while (right < nums.length) {
            if (right - left + 1 == k) {

                if (prevMaxIndex < 0 || prevMaxIndex < left) {
                    localMax = Integer.MIN_VALUE;
                    for (int i = left; i <= right; i++) {
                        if (localMax < nums[i]) {
                            localMax = nums[i];
                            prevMaxIndex = i;
                        }
                    }
                } else {
                    if (nums[right] > nums[prevMaxIndex]) {
                        localMax = nums[right];
                        prevMaxIndex = right;
                    }
                }

                solution[left] = localMax;

                left++;
            }

            right++;
        }

        return solution;

    }

    public static void main(String[] args) {

        // int[] nums = { 1, -1 };
        // int k = 1;
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(nums, k)));

    }

}