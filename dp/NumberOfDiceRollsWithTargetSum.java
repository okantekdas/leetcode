package leetcode.dp;

import java.util.Arrays;

/* https://leetcode.com/problems/number-of-dice-rolls-with-target-sum */
public class NumberOfDiceRollsWithTargetSum {

    public int numRollsToTarget(int d, int f, int target) {

        long[][] memo = new long[d + 1][target + 1];
        for (long[] dice : memo) {
            Arrays.fill(dice, -1);
        }

        return (int) calculateNumRollsToTarget(d, f, target, memo);

    }

    public long calculateNumRollsToTarget(int d, int f, int target, long[][] memo) {
        if (d == 0 || target <= 0) {
            return d == target ? 1 : 0;
        }

        if (memo[d][target] != -1) {
            return memo[d][target];
        }

        memo[d][target] = 0;
        for (int i = 1; i <= f; i++) {
            memo[d][target] += calculateNumRollsToTarget(d - 1, f, target - i, memo);
        }

        memo[d][target] %= 1000000007;

        return memo[d][target];
    }

    public static void main(String[] args) {
        int d = 30;
        int f = 30;
        int target = 500;
        System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(d, f, target));

    }

}