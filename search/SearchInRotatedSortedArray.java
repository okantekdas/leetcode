package leetcode.search;

/* https://leetcode.com/problems/search-in-rotated-sorted-array/ */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        return binarySearch(nums, 0, nums.length - 1, target);

    }

    private int binarySearch(int[] nums, int left, int right, int target) {

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

        int middleIndex = -1;
        if ((right - left) % 2 == 1) {
            middleIndex = left + (right - left) / 2;
        } else {
            middleIndex = left - 1 + (right - left) / 2;
        }
        int leftNumber = nums[left];
        int leftEndNumber = nums[middleIndex];
        int rightBeginNumber = nums[middleIndex + 1];
        int rightNumber = nums[right];

        int result = -1;
        // ordered scenario
        if (leftNumber <= target && target <= leftEndNumber) {
            result = binarySearch(nums, left, middleIndex, target);
        } else if (rightBeginNumber <= target && target <= rightNumber) {
            result = binarySearch(nums, middleIndex + 1, right, target);
        } else {
            int resutlt1 = binarySearch(nums, left, middleIndex, target);
            int result2 = binarySearch(nums, middleIndex + 1, right, target);
            result = Math.max(resutlt1, result2);

        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {};
        int target = 3;

        System.out.println(new SearchInRotatedSortedArray().search(nums, target));
    }

}