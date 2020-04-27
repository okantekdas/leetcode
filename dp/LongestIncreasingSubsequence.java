package leetcode.dp;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max = 0;
        int[] memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, calculateLis(nums, i, memo));
        }

        return max;
    }

    private int calculateLis(int[] nums, int left, int[] memo) {

        if (memo[left] > 0) {
            return memo[left];
        }
        if (left >= nums.length) {
            return 0;
        }

        int max = 1;

        for (int i = left + 1; i < nums.length; i++) {

            if (nums[left] < nums[i]) {
                max = Math.max(max, calculateLis(nums, i, memo) + 1);
            }

        }

        memo[left] = max;
        return max;
    }

    public static void main(String[] args) {
        // int[] nums = { 4, 10, 4, 3, 8, 9 };
        // int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        int[] nums = { 1, 2, 3, 4, 5, 6 };

        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
    }

}