package leetcode.search;

/*https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/*/
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {

        return findMin(nums, 0, nums.length - 1);
    }

    public int findMin(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        if (left == right - 1) {
            if (nums[left] > nums[right]) {
                return nums[right];
            } else {
                return nums[left];
            }
        }

        int midIndex = left + (right - left) / 2;

        if (nums[left] > nums[midIndex]) {
            return findMin(nums, left, midIndex);
        } else if (nums[midIndex] > nums[right]) {
            return findMin(nums, midIndex, right);
        } else {
            return nums[left];
        }

    }
}
