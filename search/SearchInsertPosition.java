package leetcode.search;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {

        return binarySearch(nums, target, 0, nums.length - 1);

    }

    public int binarySearch(int[] nums, int target, int left, int right) {
        if (right < left) {
            return left;
        }
        if (left > right) {
            return right + 1;
        }

        if (left == right) {
            if (nums[left] == target) {
                return left;
            } else if (nums[left] < target) {
                return left + 1;
            } else if (nums[left] > target) {
                return left;
            }
        }

        int midIndex = left + (right - left) / 2;
        if (nums[midIndex] > target) {
            return binarySearch(nums, target, left, midIndex - 1);
        } else if (nums[midIndex] < target) {
            return binarySearch(nums, target, midIndex + 1, right);

        } else {
            return midIndex;
        }
    }

    public static void main(String[] args) {

        int[] nums = { 1, 3, 5, 6 };
        int target = 2;
        // int[] nums = { 1, 3 };
        // int target = 0;

        System.out.println(new SearchInsertPosition().searchInsert(nums, target));

    }

}