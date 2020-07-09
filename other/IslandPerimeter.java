package leetcode.other;

/* https://leetcode.com/problems/island-perimeter/ */
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {

        int perimeter = 0;

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 1) {
                    perimeter += 4;
                    if (y > 0) {
                        if (grid[y - 1][x] == 1) {
                            perimeter--;
                        }
                    }
                    if (y < grid.length - 1) {
                        if (grid[y + 1][x] == 1) {
                            perimeter--;
                        }
                    }
                    if (x > 0) {
                        if (grid[y][x - 1] == 1) {
                            perimeter--;
                        }
                    }
                    if (x < grid[0].length - 1) {
                        if (grid[y][x + 1] == 1) {
                            perimeter--;
                        }
                    }
                }
            }
        }
        return perimeter;
    }
}