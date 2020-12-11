package leetcode.arrays;

/* https://leetcode.com/problems/remove-duplicates-from-sorted-array/ */
/* Runtime: 0 ms, faster than 100.00% */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {

        int left = 0;
        int right = 1;

        int counter = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
                counter++;
            }
            right++;
        }

        return counter;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1 };

        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(nums));
    }
}
