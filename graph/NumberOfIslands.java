package leetcode.graph;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int islandCount = 0;

        for (int y = 0; y < grid.length; y++) {

            for (int x = 0; x < grid[y].length; x++) {
                if (!visited[y][x] && grid[y][x] != '0') {

                    traverseGraph(grid, visited, y, x);
                    islandCount++;
                }

            }

        }

        return islandCount;

    }

    private void traverseGraph(char[][] grid, boolean[][] visited, int y, int x) {

        if (x == grid[0].length || x < 0 || y == grid.length || y < 0 || visited[y][x]) {
            return;
        }

        if (grid[y][x] == '0') {
            visited[y][x] = true;
            return;
        }

        visited[y][x] = true;
        traverseGraph(grid, visited, y, x + 1);
        traverseGraph(grid, visited, y, x - 1);
        traverseGraph(grid, visited, y + 1, x);
        traverseGraph(grid, visited, y - 1, x);

    }

    public static void main(String[] args) {

        // char[][] grid = { { '1', '1', '1' }, { '0', '1', '0' }, { '1', '1', '1', } };

        char[][] grid = { { '1', '1', '1', '0', '1' }, { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '1', '1' } };

        System.out.println(new NumberOfIslands().numIslands(grid));
    }

}