package leetcode.backtracking;

/* https://leetcode.com/problems/unique-paths-iii/ */
public class UniquePaths3 {
    public int uniquePathsIII(int[][] grid) {

        int zeroCount = 0;
        int xC = 0, yC = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 0) {
                    zeroCount++;
                } else if (grid[y][x] == 1) {
                    xC = x;
                    yC = y;
                    grid[y][x] = 0;
                    zeroCount++;
                }
            }
        }

        return uniquePathsIII(grid, xC, yC, zeroCount);
    }

    public int uniquePathsIII(int[][] grid, int x, int y, int zeroCount) {

        if (x < 0 || x >= grid[0].length || y < 0 || y >= grid.length || grid[y][x] == 1 || grid[y][x] == -1) {
            return 0;
        }
        if (grid[y][x] == 2) {
            return zeroCount == 0 ? 1 : 0;

        }

        int solution = 0;

        grid[y][x] = 1;

        solution += uniquePathsIII(grid, x + 1, y, zeroCount - 1);
        solution += uniquePathsIII(grid, x - 1, y, zeroCount - 1);
        solution += uniquePathsIII(grid, x, y + 1, zeroCount - 1);
        solution += uniquePathsIII(grid, x, y - 1, zeroCount - 1);

        grid[y][x] = 0;

        return solution;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 2 } };
        System.out.println(new UniquePaths3().uniquePathsIII(grid));
    }
}
