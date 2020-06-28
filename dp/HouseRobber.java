package leetcode.dp;

import java.util.Arrays;

/* https://leetcode.com/problems/house-robber/ */
public class HouseRobber {
    public int rob(int[] nums) {

        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return rob(nums, memo, 0);

    }

    public int rob(int[] nums, int[] memo, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (memo[index] > -1) {
            return memo[index];
        }

        int max = Integer.MIN_VALUE;
        for (int i = index; i < nums.length; i++) {
            int total = 0;
            total = nums[i] + rob(nums, memo, i + 2);
            max = Math.max(max, total);
        }

        memo[index] = max;
        return max;
    }

}