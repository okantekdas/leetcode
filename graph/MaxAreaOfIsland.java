package leetcode.graph;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int maxArea = 0;

        for (int y = 0; y < grid.length; y++) {

            for (int x = 0; x < grid[y].length; x++) {
                if (!visited[y][x] && grid[y][x] != 0) {

                    int area = traverseGraph(grid, visited, y, x);

                    if (area > maxArea) {
                        maxArea = area;
                    }
                }

            }

        }

        return maxArea;

    }

    private int traverseGraph(int[][] grid, boolean[][] visited, int y, int x) {
        if (x == grid[0].length || x < 0 || y == grid.length || y < 0 || visited[y][x]) {
            return 0;
        }

        if (grid[y][x] == 0) {
            visited[y][x] = true;
            return 0;
        }

        visited[y][x] = true;
        int area = 1;
        area += traverseGraph(grid, visited, y, x + 1);
        area += traverseGraph(grid, visited, y, x - 1);
        area += traverseGraph(grid, visited, y + 1, x);
        area += traverseGraph(grid, visited, y - 1, x);

        return area;
    }

    public static void main(String[] args) {

        int[][] grid = { { 0, 0, 1, 0, 1 }, { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 } };

        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));

    }

}