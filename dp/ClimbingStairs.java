package leetcode.dp;

/* https://leetcode.com/problems/climbing-stairs */
public class ClimbingStairs {

    public int climbStairs(int n) {

        int[] dp = new int[n + 1];

        return calculateClimbStairs(n, dp);

    }

    public int calculateClimbStairs(int n, int[] dp) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        int var1 = calculateClimbStairs(n - 1, dp);
        int var2 = calculateClimbStairs(n - 2, dp);

        dp[n] = var1 + var2;

        return var1 + var2;
    }

    public static void main(String[] args) {

        System.out.println(new ClimbingStairs().climbStairs(4));

    }

}