package leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/* https://leetcode.com/problems/path-with-minimum-effort/ */
/* Runtime: 71 ms, faster than 51.81% */
public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {

        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        int[][] distances = new int[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        minHeap.add(new int[] { 0, 0, 0 });

        while (!minHeap.isEmpty()) {
            int[] result = minHeap.poll();

            int distance = result[0];
            int row = result[1];
            int column = result[2];

            if (distance > distances[row][column]) {
                continue;
            }

            if (row == heights.length - 1 && column == heights[0].length - 1) {
                return distance;
            }

            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextColumn = column + direction[1];

                if (nextRow >= 0 && nextRow < heights.length && nextColumn >= 0 && nextColumn < heights[0].length) {
                    int nextDistance = Math.max(distance,
                            Math.abs(heights[row][column] - heights[nextRow][nextColumn]));
                    if (nextDistance < distances[nextRow][nextColumn]) {
                        distances[nextRow][nextColumn] = nextDistance;
                        minHeap.add(new int[] { nextDistance, nextRow, nextColumn });
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}
