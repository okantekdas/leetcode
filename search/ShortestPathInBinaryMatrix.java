package leetcode.search;

import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/shortest-path-in-binary-matrix/ */
/* Runtime: 13 ms, faster than 79.36% Memory Usage: 39.6 MB, less than 98.38% */
public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {

        boolean[][] added = new boolean[grid.length][grid[0].length];

        Queue<int[]> queue = new LinkedList<>();

        if (grid[0][0] == 0) {
            queue.add(new int[] { 0, 0 });
            added[0][0] = true;
        }

        int current = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            current++;
            for (int i = 0; i < size; i++) {
                int[] coordinate = queue.poll();
                int y = coordinate[0];
                int x = coordinate[1];
                if (y == grid.length - 1 && x == grid[0].length - 1) {
                    return current + 1;
                }
                for (int a = -1; a < 2; a++) {
                    for (int b = -1; b < 2; b++) {
                        int xNext = x + a;
                        int yNext = y + b;

                        if (xNext >= 0 && xNext < grid[0].length && yNext >= 0 && yNext < grid.length
                                && !added[yNext][xNext] && grid[yNext][xNext] == 0) {

                            queue.add(new int[] { yNext, xNext });
                            added[yNext][xNext] = true;

                        }
                    }
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 1, 0 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 }, { 0, 0, 0, 0 } };

        System.out.println(new ShortestPathInBinaryMatrix().shortestPathBinaryMatrix(grid));
    }
}
