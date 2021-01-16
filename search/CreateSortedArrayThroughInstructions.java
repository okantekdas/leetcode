package leetcode.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* https://leetcode.com/problems/create-sorted-array-through-instructions/ */
/*
 * Runtime: 1781 ms, faster than 8.64% Memory Usage: 54.4 MB, less than 81.54%
 */
public class CreateSortedArrayThroughInstructions {

    private static final int mod = (int) 1e9 + 7;

    public int createSortedArray(int[] instructions) {

        List<Integer> nums = new ArrayList<>();
        long cost = 0;
        nums.add(instructions[0]);
        for (int i = 1; i < instructions.length; i++) {
            int instruction = instructions[i];

            int leftIndex = findClosestLevel(nums, instruction, 0, nums.size() - 1, true);
            int rightIndex = findClosestLevel(nums, instruction + 1, 0, nums.size() - 1, false);

            if (nums.get(rightIndex) <= instruction) {
                rightIndex = nums.size() + 1;
            } else {
                rightIndex++;
            }

            if (nums.get(leftIndex) >= instruction) {
                leftIndex = leftIndex - 1;
            }

            int index = rightIndex - 1;

            nums.add(index, instruction);

            int leftCount = 0;
            leftCount = leftIndex + 1;
            int rightCount = 0;
            if (rightIndex > 0 && rightIndex < nums.size()) {
                rightCount = nums.size() - rightIndex;
            }

            cost += Math.min(leftCount, rightCount);

        }

        return (int) (cost % mod);
    }

    /* TLE */
    public int createSortedArrayAlternate(int[] instructions) {

        List<Integer> nums = new ArrayList<>();
        int cost = 0;
        for (int i = 0; i < instructions.length; i++) {
            int instruction = instructions[i];

            int index = Collections.binarySearch(nums, instruction);

            int rightIndex = 0;
            int leftIndex = 0;

            if (index < 0) {
                // does not exist
                index = -index - 1;
                leftIndex = index - 1;
                rightIndex = index + 1;
            } else {
                // check if same number exists
                if (nums.get(index) == instruction) {
                    // find left most

                    int indexCopy = index;

                    while (indexCopy > -1 && nums.get(indexCopy) == instruction) {
                        indexCopy--;
                    }
                    leftIndex = indexCopy;
                    indexCopy = index;
                    while (indexCopy < nums.size() && nums.get(indexCopy) == instruction) {
                        indexCopy++;
                    }
                    rightIndex = indexCopy + 1;
                } else {
                    leftIndex = index - 1;
                    rightIndex = index + 1;
                }
            }

            nums.add(index, instruction);

            int leftCount = 0;
            leftCount = leftIndex + 1;
            int rightCount = 0;
            if (rightIndex <= nums.size() - 1) {
                rightCount = nums.size() - rightIndex;
            }

            cost += Math.min(leftCount, rightCount);
            cost = cost % mod;
        }

        return cost;
    }

    private int findClosestLevel(List<Integer> nums, int target, int left, int right, boolean isSmaller) {
        if (left == right) {
            return left;
        }

        int midIndex = left + (right - left) / 2;

        int result = -1;
        if (nums.get(midIndex) < target) {
            result = findClosestLevel(nums, target, midIndex + 1, right, isSmaller);
        } else {
            result = findClosestLevel(nums, target, left, midIndex, isSmaller);
        }

        if ((isSmaller && (nums.get(result) <= target) || result == 0)
                || (!isSmaller && (nums.get(result) >= target) || result == nums.size() - 1)) {
            return result;
        }

        return midIndex;
    }

    public static void main(String[] args) {

        int[] instructions = { 1, 12, 12, 12, 13, 13, 14, 12, 13, 14, 1 };
        System.out.println(new CreateSortedArrayThroughInstructions().createSortedArray(instructions));
    }
}
