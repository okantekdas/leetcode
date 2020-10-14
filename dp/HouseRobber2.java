package leetcode.dp;

import java.util.Arrays;

/* https://leetcode.com/problems/house-robber-ii/ */
/* Runtime: 0 ms, faster than 100.00% */
public class HouseRobber2 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        int solution1 = rob(Arrays.copyOfRange(nums, 0, nums.length - 1), memo, 0);
        Arrays.fill(memo, -1);
        int solution2 = rob(Arrays.copyOfRange(nums, 1, nums.length), memo, 0);

        return Math.max(solution1, solution2);

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

    public static void main(String[] args) {
        int[] nums = { 6, 6, 4, 8, 4, 3, 3, 10 };
        System.out.println(new HouseRobber2().rob(nums));
    }

}