package leetcode.dp;

import java.util.Arrays;

public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {

        int memo[][] = new int[dungeon.length][];

        for (int i = 0; i < dungeon.length; i++) {
            int[] mem = new int[dungeon[i].length];
            Arrays.fill(mem, Integer.MIN_VALUE);
            memo[i] = mem;
        }
        int solution = calculateMinimumHPHelper(dungeon, 0, 0, memo);

        return solution <= 0 ? -solution + 1 : 1;
    }

    public int calculateMinimumHPHelper(int[][] dungeon, int y, int x, int[][] memo) {

        if (y == dungeon.length - 1 && x == dungeon[0].length - 1) {
            return dungeon[y][x];
        }

        if (y > dungeon.length - 1 || x > dungeon[0].length - 1) {
            return Integer.MIN_VALUE;
        }

        if (memo[y][x] != Integer.MIN_VALUE) {
            return memo[y][x];
        }

        int health = dungeon[y][x];

        int rightSolution = calculateMinimumHPHelper(dungeon, y, x + 1, memo);
        int downSolution = calculateMinimumHPHelper(dungeon, y + 1, x, memo);

        int optimalSubsolution = Math.max(rightSolution, downSolution);
        int solution = health;
        if (optimalSubsolution < 0) {
            solution = health + optimalSubsolution;
        } else {
            solution = Math.min(solution, optimalSubsolution);
        }
        memo[y][x] = solution;

        return solution;
    }

    public static void main(String[] args) {
        int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };

        System.out.println(new DungeonGame().calculateMinimumHP(dungeon));
    }

}