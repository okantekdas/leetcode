package leetcode.arrays;

/* https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/ */
/* Runtime: 0 ms, faster than 100.00% Memory Usage: 39 MB, less than 68.14% */
public class RemoveDuplicatesFromSortedArray2 {

    public int removeDuplicates(int[] nums) {

        int index = 0;
        int left = 0;
        int right = 0;

        int counter = 0;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                int diff = right - left;

                if (diff > 2) {
                    left = right;
                } else {
                    left += diff;
                }
            }

            if (nums[left] == nums[right] && right - left < 2) {
                nums[index++] = nums[left];
                counter++;
            }
            right++;
        }

        return counter;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };

        System.out.println(new RemoveDuplicatesFromSortedArray2().removeDuplicates(nums));
    }
}
