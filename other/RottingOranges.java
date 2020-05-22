package leetcode.other;

import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/rotting-oranges/ */
public class RottingOranges {

    public int orangesRotting(int[][] grid) {

        int freshCount = 0;
        Queue<int[]> rottenQueue = new LinkedList<>();
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 2) {
                    int[] coordinate = new int[2];
                    coordinate[0] = x;
                    coordinate[1] = y;
                    rottenQueue.add(coordinate);
                } else if (grid[y][x] == 1) {
                    freshCount++;
                }
            }
        }

        int turn = 0;

        while (!rottenQueue.isEmpty()) {

            int queueSize = rottenQueue.size();

            boolean hasRotten = false;
            for (int i = 0; i < queueSize; i++) {

                int[] coordinate = rottenQueue.poll();

                if (coordinate[1] - 1 >= 0 && grid[coordinate[1] - 1][coordinate[0]] == 1) {
                    grid[coordinate[1] - 1][coordinate[0]] = 2;
                    int[] c = new int[2];
                    c[0] = coordinate[0];
                    c[1] = coordinate[1] - 1;
                    rottenQueue.add(c);
                    freshCount--;
                    hasRotten = true;

                }
                if (coordinate[1] + 1 < grid.length && grid[coordinate[1] + 1][coordinate[0]] == 1) {
                    grid[coordinate[1] + 1][coordinate[0]] = 2;
                    int[] c = new int[2];
                    c[0] = coordinate[0];
                    c[1] = coordinate[1] + 1;
                    rottenQueue.add(c);
                    freshCount--;
                    hasRotten = true;
                }
                if (coordinate[0] - 1 >= 0 && grid[coordinate[1]][coordinate[0] - 1] == 1) {
                    grid[coordinate[1]][coordinate[0] - 1] = 2;
                    int[] c = new int[2];
                    c[0] = coordinate[0] - 1;
                    c[1] = coordinate[1];
                    rottenQueue.add(c);
                    freshCount--;
                    hasRotten = true;
                }
                if (coordinate[0] + 1 < grid[0].length && grid[coordinate[1]][coordinate[0] + 1] == 1) {
                    grid[coordinate[1]][coordinate[0] + 1] = 2;
                    int[] c = new int[2];
                    c[0] = coordinate[0] + 1;
                    c[1] = coordinate[1];
                    rottenQueue.add(c);
                    freshCount--;
                    hasRotten = true;
                }

            }
            if (hasRotten) {
                turn++;
            }
        }

        return freshCount == 0 ? turn : -1;

    }

    public static void main(String[] args) {

        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        // int[][] grid = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
        // int[][] grid = { { 0, 1 } };

        System.out.println(new RottingOranges().orangesRotting(grid));
    }

}