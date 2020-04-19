package leetcode.search;

public class SearchInRotatedSortedArray2 {

    public boolean search(int[] nums, int target) {

        return binarySearch(nums, 0, nums.length - 1, target);

    }

    private boolean binarySearch(int[] nums, int left, int right, int target) {

        if (left > right) {
            return false;
        }
        if (left == right) {
            if (nums[left] == target) {
                return true;
            } else {
                return false;
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

        boolean result = false;
        // ordered scenario
        if (leftNumber <= target && target <= leftEndNumber) {
            result = binarySearch(nums, left, middleIndex, target);
        } else if (rightBeginNumber <= target && target <= rightNumber) {
            result = binarySearch(nums, middleIndex + 1, right, target);
        } else {
            result |= binarySearch(nums, left, middleIndex, target);
            result |= binarySearch(nums, middleIndex + 1, right, target);

        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = { 2, 5, 6, 0, 0, 1, 2 };
        int target = 3;

        System.out.println(new SearchInRotatedSortedArray2().search(nums, target));
    }

}