package leetcode.search;

/*https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/*/
public class FindMinimumInRotatedSortedArray2 {
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

        int leftSolution = nums[left];
        int rightSolution = nums[right];
        if (nums[left] >= nums[midIndex]) {
            leftSolution = findMin(nums, left, midIndex);
        }
        if (nums[midIndex] >= nums[right]) {
            rightSolution = findMin(nums, midIndex, right);
        }

        return rightSolution < leftSolution ? rightSolution : leftSolution;
    }


    public static void main(String[] args) {
        int[] nums = {4};
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int[] nums = {2, 2, 2, 0, 1};
//        int[] nums = {3, 3, 1, 3};
//        int[] nums = {1, 3, 5};
//        int[] nums = {1, 1};

        System.out.println(new FindMinimumInRotatedSortedArray2().findMin(nums));
    }
}
