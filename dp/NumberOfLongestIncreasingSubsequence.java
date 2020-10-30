package leetcode.dp;

import java.util.Arrays;

/* https://leetcode.com/problems/number-of-longest-increasing-subsequence */
/* Runtime: 20 ms, faster than 23.44% */
public class NumberOfLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {

        if (nums.length <= 1) {
            return nums.length;
        }

        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);

        int globalMax = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] >= dp[i]) {

                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                        globalMax = Math.max(globalMax, dp[i]);
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }

            }
        }
        int s = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (dp[i] == globalMax) {
                s += count[i];
            }
        }
        return s;
    }

    int[][] solution;
    int[] memo;
    int max;

    /* Runtime: 60 ms, faster than 5.17% */
    public int findNumberOfLISAlternate(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        solution = new int[nums.length][nums.length + 1];
        memo = new int[nums.length];
        findLIS(nums, 0);
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += solution[i][max];
        }

        return total;
    }

    public int findLIS(int[] nums, int index) {

        if (memo[index] > 0) {
            return memo[index];
        }

        int maxLength = 1;

        for (int i = index + 1; i < nums.length; i++) {

            int maxSubLength = 1 + findLIS(nums, i);
            if (nums[index] < nums[i]) {
                solution[index][maxSubLength] += solution[i][maxSubLength - 1];
                maxLength = Math.max(maxLength, maxSubLength);
                max = Math.max(max, maxSubLength);
            }
        }

        if (solution[index][maxLength] == 0) {

            solution[index][maxLength]++;
            max = Math.max(max, solution[index][maxLength]);
        }
        memo[index] = maxLength;
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 3, 5, 4, 7, 2 };
        System.out.println(new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(nums));
    }
}
