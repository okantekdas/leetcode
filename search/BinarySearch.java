package leetcode.search;

/* https://leetcode.com/problems/binary-search/ */
public class BinarySearch {

    public int search(int[] nums, int target) {
        return searchBinary(nums, target, 0, nums.length - 1);
    }

    public int searchBinary(int[] nums, int target, int left, int right) {

        if (left > right) {
            return -1;
        }
        if (left == right) {
            if (nums[left] == target) {
                return left;
            } else {
                return -1;
            }
        }

        int midIndex = left + (right - left) / 2;

        if (nums[midIndex] == target) {
            return midIndex;
        }

        if (nums[midIndex] < target) {
            return searchBinary(nums, target, midIndex + 1, right);
        } else {
            return searchBinary(nums, target, left, midIndex);
        }

    }

}