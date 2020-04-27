package leetcode.dp;

import java.util.Arrays;

public class CoinChange {

    /* Runtime: 11 ms, faster than 87.47% */
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {

                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }

            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /* Runtime: 23 ms, faster than 30.27% */
    public int coinChangeAlternate(int[] coins, int amount) {
        return calculateCoinChange(coins, amount, new int[amount]);
    }

    public int calculateCoinChange(int[] coins, int amount, int[] memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        if (memo[amount] != 0) {
            return memo[amount];
        }

        int subsolution = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {

            int solution = 1 + calculateCoinChange(coins, amount - coins[i], memo);
            if (solution > 0) {
                subsolution = Math.min(solution, subsolution);
            }

        }
        subsolution = subsolution == Integer.MAX_VALUE ? -1 : subsolution;
        memo[amount] = subsolution;
        return subsolution;
    }

    public static void main(String[] args) {

        int[] coins = { 1, 2, 5 };

        int amount = 11;

        System.out.println(new CoinChange().coinChange(coins, amount));

    }

}