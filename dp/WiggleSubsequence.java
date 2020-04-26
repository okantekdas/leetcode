package leetcode.dp;

import java.util.HashMap;

/* https://leetcode.com/problems/wiggle-subsequence */
public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int[] increase = new int[nums.length];
        int[] decrease = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                decrease[i] = increase[i - 1] + 1;
                increase[i] = increase[i - 1];
            } else if (nums[i] > nums[i - 1]) {
                increase[i] = decrease[i - 1] + 1;
                decrease[i] = decrease[i - 1];
            } else {
                increase[i] = increase[i - 1];
                decrease[i] = decrease[i - 1];
            }
        }

        return 1 + Math.max(increase[nums.length - 1], decrease[nums.length - 1]);
    }

    HashMap<Integer, Integer> indexToCountInc = new HashMap<>();
    HashMap<Integer, Integer> indexToCountDec = new HashMap<>();

    /* Runtime: 23 ms, faster than 5.11% */
    public int wiggleMaxLengthAlternate(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        return Math.max(calculateWiggle(nums, 0, true), calculateWiggle(nums, 0, false));
    }

    public int calculateWiggle(int nums[], int left, boolean isIncrease) {

        if (isIncrease && indexToCountInc.containsKey(left)) {
            return indexToCountInc.get(left);
        }

        if (!isIncrease && indexToCountDec.containsKey(left)) {
            return indexToCountDec.get(left);
        }

        if (left == nums.length - 1) {
            return 1;
        }

        int max = 1;
        int increaseCount = 0;
        int decreaseCount = 0;
        for (int i = left + 1; i < nums.length; i++) {

            if (nums[left] < nums[i] && isIncrease) {
                increaseCount = 1 + calculateWiggle(nums, i, false);
                max = Math.max(max, increaseCount);
                indexToCountInc.put(left, max);
            } else if (nums[left] > nums[i] && !isIncrease) {
                decreaseCount = 1 + calculateWiggle(nums, i, true);
                max = Math.max(max, decreaseCount);
                indexToCountDec.put(left, max);

            }

        }

        return max;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };

        System.out.println(new WiggleSubsequence().wiggleMaxLength(nums));
    }

}