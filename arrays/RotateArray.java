package leetcode.arrays;

/* https://leetcode.com/problems/rotate-array/ */
/* Runtime: 0 ms, faster than 100.00% */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        int change = 0;
        for (int i = 0; change < nums.length; i++) {
            int rightNum = nums[i];
            int j = i + k;
            for (; j != i; j = (j + k) % nums.length) {
                int leftNum = nums[j];
                nums[j] = rightNum;
                rightNum = leftNum;
                change++;
            }
            nums[j] = rightNum;
            change++;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1 };
        new RotateArray().rotate(nums, 3);
    }
}
