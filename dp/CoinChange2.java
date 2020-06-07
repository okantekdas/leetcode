package leetcode.dp;

import java.util.Arrays;

public class CoinChange2 {
    public int change(int amount, int[] coins) {

        if (amount == 0 && (coins == null || coins.length == 0)) {
            return 1;
        }

        if (coins == null || coins.length == 0) {
            return 0;
        }

        int[][] memo = new int[coins.length][amount + 1];

        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return calculateChange(amount, coins, 0, memo);
    }

    public int calculateChange(int amount, int[] coins, int index, int[][] memo) {
        if (index >= coins.length) {
            return 0;
        }
        if (amount < 0) {
            return 0;
        }
        if (amount == 0) {
            return 1;
        }

        if (memo[index][amount] > -1) {
            return memo[index][amount];
        }
        int result = 0;

        if (coins[index] <= amount) {
            result += calculateChange(amount - coins[index], coins, index, memo);
        }
        result += calculateChange(amount, coins, index + 1, memo);

        memo[index][amount] = result;

        return result;

    }

    public static void main(String[] args) {

        int amount = 500;
        int[] coins = { 1, 2, 5 };

        System.out.println(new CoinChange2().change(amount, coins));

    }

}