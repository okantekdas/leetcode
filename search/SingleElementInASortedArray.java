package leetcode.search;

/* https://leetcode.com/problems/single-element-in-a-sorted-array/ */
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        calculateSingleNonDuplicate(nums, 0, nums.length - 1);
        return solution;

    }

    int solution = 1;

    public void calculateSingleNonDuplicate(int[] nums, int left, int right) {

        if (left > right) {
            return;
        }

        int mid = left + (right - left) / 2;
        int midVal = nums[mid];
        if ((mid - 1 >= 0 && midVal != nums[mid - 1])) {
            if (mid + 1 >= nums.length || midVal != nums[mid + 1]) {
                solution = midVal;
                return;
            }

        }
        if ((mid + 1 < nums.length && midVal != nums[mid + 1])) {
            if (mid - 1 < 0 || midVal != nums[mid - 1]) {
                solution = midVal;
                return;
            }

        }

        calculateSingleNonDuplicate(nums, left, mid - 1);
        calculateSingleNonDuplicate(nums, mid + 1, right);

    }

    public static void main(String[] args) {
        // int[] nums = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        // int[] nums = { 3, 3, 7, 7, 10, 11, 11 };
        // int[] nums = { 1, 3, 3, 7, 7, 10, 10, 11, 11 };
        // int[] nums = { 1, 1, 3, 3, 7, 7, 10, 10, 11, 11, 12 };
        int[] nums = { 1, 3, 3, 4, 7, 7, 10, 10, 11, 11 };

        System.out.println(new SingleElementInASortedArray().singleNonDuplicate(nums));
    }
}