package leetcode.recursion;

public class MaximumSubArray {

    public int maxSubArray(int[] nums) {

        return maxSubArray(nums, 0);

    }

    static int max = Integer.MIN_VALUE;

    public int maxSubArray(int[] nums, int start) {

        if (start == nums.length - 1) {
            if (nums[start] > max) {
                max = nums[start];
            }
            return nums[start];
        }

        int result = 0;
        result = nums[start];
        int subtotal = maxSubArray(nums, start + 1);

        if (subtotal > 0) {
            result += subtotal;
        }

        if (result > max) {
            max = result;
        }

        return result;

    }

    public static void main(String[] args) {

        int[] nums = { 8, -19, 5, -4, 20 };
        new MaximumSubArray().maxSubArray(nums);
        System.out.println("Max: " + max);

    }
}