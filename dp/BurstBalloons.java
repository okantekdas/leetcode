package leetcode.dp;

/* https://leetcode.com/problems/burst-balloons/ */
/* Runtime: 9 ms, faster than 39.95% Memory Usage: 36.6 MB, less than 70.15 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {

        int[] numbers = new int[nums.length + 2];
        int[][] memo = new int[numbers.length][numbers.length];
        numbers[0] = 1;
        numbers[nums.length + 1] = 1;

        int i = 1;
        for (int num : nums) {
            numbers[i++] = num;
        }

        return maxCoinsHelper(memo, numbers, 0, numbers.length - 1);
    }

    public int maxCoinsHelper(int[][] memo, int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }

        if (memo[left][right] > 0) {
            return memo[left][right];
        }

        int max = 0;

        for (int i = left + 1; i < right; i++) {
            max = Math.max(max, nums[left] * nums[i] * nums[right] + maxCoinsHelper(memo, nums, left, i)
                    + maxCoinsHelper(memo, nums, i, right));
        }

        memo[left][right] = max;

        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 5, 6, 8 };

        System.out.println(new BurstBalloons().maxCoins(nums));
    }
}
