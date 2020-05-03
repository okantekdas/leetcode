package leetcode.dp;

/* https://leetcode.com/problems/unique-paths/ */
public class UniquePaths {

    public int uniquePaths(int m, int n) {

        return calculateUniquePaths(m - 1, n - 1, new int[n][m]);

    }

    public int calculateUniquePaths(int m, int n, int[][] memo) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }

        if (memo[n][m] != 0) {
            return memo[n][m];
        }

        // right
        int right = calculateUniquePaths(m - 1, n, memo);
        // down
        int down = calculateUniquePaths(m, n - 1, memo);

        memo[n][m] = right + down;

        return memo[n][m];

    }

    public static void main(String[] args) {
        int m = 7;
        int n = 3;

        System.out.println(new UniquePaths().uniquePaths(m, n));
    }

}