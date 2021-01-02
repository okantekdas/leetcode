package leetcode.dp;

import java.util.Arrays;

/* https://leetcode.com/problems/cherry-pickup-ii/ */
/* Runtime: 18 ms, faster than 49.01% Memory Usage: 39.4 MB, less than 64.63% */
public class CherryPickup2 {

    public int cherryPickup(int[][] grid) {

        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return cherryPickupHelper(grid, 0, 0, grid[0].length - 1, dp);
    }

    public int cherryPickupHelper(int[][] grid, int row, int col1, int col2, int[][][] dp) {
        if (row >= grid.length || col1 >= grid[0].length || col2 >= grid[0].length || col1 < 0 || col2 < 0) {
            return 0;
        }
        int result = grid[row][col1];
        if (col1 != col2) {
            result += grid[row][col2];
        }

        if (dp[row][col1][col2] > -1) {
            return dp[row][col1][col2];
        }

        int max = 0;
        for (int nextCol1 = -1; nextCol1 < 2; nextCol1++) {

            for (int nextCol2 = -1; nextCol2 < 2; nextCol2++) {
                max = Math.max(max, cherryPickupHelper(grid, row + 1, col1 + nextCol1, col2 + nextCol2, dp));
            }
        }

        result += max;
        dp[row][col1][col2] = result;

        return result;
    }

    public static void main(String[] args) {

        int[][] grid = { { 3, 1, 1 }, { 2, 5, 1 }, { 1, 5, 5 }, { 2, 1, 1 } };
        System.out.println(new CherryPickup2().cherryPickup(grid));
    }

}
