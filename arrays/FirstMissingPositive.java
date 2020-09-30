package leetcode.arrays;

/* https://leetcode.com/problems/first-missing-positive */
/* Runtime: 0 ms, faster than 100.00% Memory Usage: 36.4 MB, less than 99.91% */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1 && nums[value - 1] != value) {
                int temp = nums[value - 1];
                nums[value - 1] = value;
                nums[i] = temp;
                i--;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, -1, 1 };
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
    }
}
