package leetcode.dp;

/* https://leetcode.com/problems/maximum-product-subarray/ */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {

        int max = Integer.MIN_VALUE;
        int[][] dp = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i][0] = nums[i];
                dp[i][1] = nums[i];
            } else {
                dp[i][0] = Math.max(nums[i], Math.max(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]));
                dp[i][1] = Math.min(nums[i], Math.min(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]));
            }
            max = Math.max(max, dp[i][0]);

        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = { -1, -2, -9, -6 };

        System.out.println(new MaximumProductSubarray().maxProduct(nums));
    }

}