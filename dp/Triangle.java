package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* https://leetcode.com/problems/triangle */
public class Triangle {

    // HashMap<Integer, HashMap<Integer, Integer>> levelToIndexMin = new
    // HashMap<>();

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] memo = new int[triangle.size()][];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = new int[triangle.get(i).size()];
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        return calculateMinimumTotal(triangle, 0, 0, memo);

    }

    public int calculateMinimumTotal(List<List<Integer>> triangle, int level, int index, int[][] memo) {

        if (triangle.size() == level) {
            return 0;
        }
        if (memo[level][index] != Integer.MAX_VALUE) {

            return memo[level][index];
        }

        List<Integer> currentLevel = triangle.get(level);

        int min = Integer.MAX_VALUE;

        min = Math.min(min, currentLevel.get(index) + calculateMinimumTotal(triangle, level + 1, index, memo));
        if (level > 0) {
            min = Math.min(min,
                    currentLevel.get(index + 1) + calculateMinimumTotal(triangle, level + 1, index + 1, memo));

        }

        memo[level][index] = min;
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(2, 3));
        triangle.add(Arrays.asList(1, -1, -3));

        System.out.println(new Triangle().minimumTotal(triangle));
    }
}