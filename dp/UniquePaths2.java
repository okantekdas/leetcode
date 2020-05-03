package leetcode.dp;

import java.util.Arrays;

/* https://leetcode.com/problems/unique-paths-ii */
public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] arr : memo) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        return calculateUniquePathsWithObstacles(obstacleGrid, 0, 0, memo);

    }

    public int calculateUniquePathsWithObstacles(int[][] obstacleGrid, int y, int x, int[][] memo) {

        if (y == memo.length - 1 && x == memo[0].length - 1 && obstacleGrid[y][x] == 0) {
            return 1;
        }
        if (y > memo.length - 1 || x > memo[0].length - 1) {
            return 0;
        }

        if (obstacleGrid[y][x] == 1) {
            memo[y][x] = 0;
            return 0;
        }

        if (memo[y][x] != Integer.MAX_VALUE) {
            return memo[y][x];
        }

        // right
        int right = calculateUniquePathsWithObstacles(obstacleGrid, y, x + 1, memo);
        // down
        int down = calculateUniquePathsWithObstacles(obstacleGrid, y + 1, x, memo);

        memo[y][x] = right + down;

        return memo[y][x];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = { { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };

        System.out.println(new UniquePaths2().uniquePathsWithObstacles(obstacleGrid));

    }

}