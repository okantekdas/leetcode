package leetcode.dp;

import java.util.Arrays;

/* https://leetcode.com/problems/target-sum */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {

        int[][] memo = new int[nums.length][2001];
        for (int[] row : memo)
            Arrays.fill(row, Integer.MIN_VALUE);

        return calculateTargetSumWays(nums, S, 0, 0, memo);
    }

    public int calculateTargetSumWays(int[] nums, int S, int sum, int left, int[][] memo) {

        if (left == nums.length && sum == S) {
            return 1;
        }
        if (left == nums.length) {
            return 0;
        }

        if (memo[left][sum + 1000] != Integer.MIN_VALUE) {
            return memo[left][sum + 1000];
        }

        int variationCount = 0;

        variationCount += calculateTargetSumWays(nums, S, sum - nums[left], left + 1, memo);
        variationCount += calculateTargetSumWays(nums, S, sum + nums[left], left + 1, memo);

        memo[left][sum + 1000] = variationCount;

        return variationCount;
    }

    public static void main(String[] args) {
        int S = 3;

        int[] nums = { 1, 1, 1, 1, 1 };

        System.out.println(new TargetSum().findTargetSumWays(nums, S));
    }
}