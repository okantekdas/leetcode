package leetcode.other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/* https://leetcode.com/problems/minimum-path-sum/ */
public class MinimumPathSum {

    public class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

    }

    public int minPathSum(int[][] grid) {

        for (int x = 1; x < grid[0].length; x++) {
            grid[0][x] += grid[0][x - 1];
        }
        for (int y = 1; y < grid.length; y++) {
            grid[y][0] += grid[y - 1][0];
        }

        for (int y = 1; y < grid.length; y++) {
            for (int x = 1; x < grid[0].length; x++) {
                grid[y][x] += Math.min(grid[y - 1][x], grid[y][x - 1]);
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }

    public int minPathSumAlternate2(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        PriorityQueue<Node> nodeQueue = new PriorityQueue<>(new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {
                if (o2.cost < o1.cost) {
                    return 1;
                } else if (o2.cost == o1.cost) {
                    return 0;
                } else {
                    return -1;
                }

            }
        });

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int x = 0;
        int y = 0;
        Node current = new Node(x, y, grid[y][x]);
        nodeQueue.add(current);
        while (!nodeQueue.isEmpty()) {

            current = nodeQueue.poll();
            x = current.x;
            y = current.y;

            visited[y][x] = true;

            if (current.x == grid[0].length - 1 && current.y == grid.length - 1) {
                break;
            }

            if (x + 1 < grid[0].length && !visited[y][x + 1]) {
                Node xNode = new Node(x + 1, y, current.cost + grid[y][x + 1]);
                if (xNode.x == grid[0].length - 1 && xNode.y == grid.length - 1) {
                    current = xNode;
                    break;
                }
                nodeQueue.add(xNode);
            }
            if (y + 1 < grid.length && !visited[y + 1][x]) {
                Node yNode = new Node(x, y + 1, current.cost + grid[y + 1][x]);
                if (yNode.x == grid[0].length - 1 && yNode.y == grid.length - 1) {
                    current = yNode;
                    break;
                }
                nodeQueue.add(yNode);
            }

        }

        return current.cost;
    }

    public int minPathSumAlternate1(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int shortestPath[][] = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(shortestPath[i], Integer.MAX_VALUE);
        }

        findShortestPath(grid, shortestPath, 0, 0, 0);
        return shortestPath[grid.length - 1][grid[0].length - 1];

    }

    public void findShortestPath(int[][] grid, int[][] shortestPath, int y, int x, int prev) {

        if (y < 0 || y == grid.length || x < 0 || x == grid[0].length) {
            return;
        }

        if (prev + grid[y][x] < shortestPath[y][x]) {
            shortestPath[y][x] = prev + grid[y][x];
        } else {
            return;
        }

        findShortestPath(grid, shortestPath, y + 1, x, shortestPath[y][x]);
        // findShortestPath(grid, shortestPath, y - 1, x, shortestPath[y][x]);

        findShortestPath(grid, shortestPath, y, x + 1, shortestPath[y][x]);
        // findShortestPath(grid, shortestPath, y, x - 1, shortestPath[y][x]);

    }

    public static void main(String[] args) {
        int[][] grid = { { 5, 4, 2, 9, 6, 0, 3, 5, 1, 4, 9, 8, 4, 9, 7, 5, 1 },
                { 3, 4, 9, 2, 9, 9, 0, 9, 7, 9, 4, 7, 8, 4, 4, 5, 8 },
                { 6, 1, 8, 9, 8, 0, 3, 7, 0, 9, 8, 7, 4, 9, 2, 0, 1 },
                { 4, 0, 0, 5, 1, 7, 4, 7, 6, 4, 1, 0, 1, 0, 6, 2, 8 },
                { 7, 2, 0, 2, 9, 3, 4, 7, 0, 8, 9, 5, 9, 0, 1, 1, 0 },
                { 8, 2, 9, 4, 9, 7, 9, 3, 7, 0, 3, 6, 5, 3, 5, 9, 6 },
                { 8, 9, 9, 2, 6, 1, 2, 5, 8, 3, 7, 0, 4, 9, 8, 8, 8 },
                { 5, 8, 5, 4, 1, 5, 6, 6, 3, 3, 1, 8, 3, 9, 6, 4, 8 },
                { 0, 2, 2, 3, 0, 2, 6, 7, 2, 3, 7, 3, 1, 5, 8, 1, 3 },
                { 4, 4, 0, 2, 0, 3, 8, 4, 1, 3, 3, 0, 7, 4, 2, 9, 8 },
                { 5, 9, 0, 4, 7, 5, 7, 6, 0, 8, 3, 0, 0, 6, 6, 6, 8 },
                { 0, 7, 1, 8, 3, 5, 1, 8, 7, 0, 2, 9, 2, 2, 7, 1, 5 },
                { 1, 0, 0, 0, 6, 2, 0, 0, 2, 2, 8, 0, 9, 7, 0, 8, 0 },
                { 1, 1, 7, 2, 9, 6, 5, 4, 8, 7, 8, 5, 0, 3, 8, 1, 5 },
                { 8, 9, 7, 8, 1, 1, 3, 0, 1, 2, 9, 4, 0, 1, 5, 3, 1 },
                { 9, 2, 7, 4, 8, 7, 3, 9, 2, 4, 2, 2, 7, 8, 2, 6, 7 },
                { 3, 8, 1, 6, 0, 4, 8, 9, 8, 0, 2, 5, 3, 5, 5, 7, 5 },
                { 1, 8, 2, 5, 7, 7, 1, 9, 9, 8, 9, 2, 4, 9, 5, 4, 0 },
                { 3, 4, 4, 1, 5, 3, 3, 8, 8, 6, 3, 5, 3, 8, 7, 1, 3 } };

        System.out.println(new MinimumPathSum().minPathSum(grid));
    }

}