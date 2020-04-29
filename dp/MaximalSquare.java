package leetcode.dp;

import java.util.HashMap;

public class MaximalSquare {

    public class Memo {
        int leftY;
        int rightY;
        int leftX;
        int rightX;

        public Memo(int leftY, int rightY, int leftX, int rightX) {
            this.leftY = leftY;
            this.rightY = rightY;
            this.leftX = leftX;
            this.rightX = rightX;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + leftX;
            result = prime * result + leftY;
            result = prime * result + rightX;
            result = prime * result + rightY;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            Memo other = (Memo) obj;

            if (leftX != other.leftX)
                return false;
            if (leftY != other.leftY)
                return false;
            if (rightX != other.rightX)
                return false;
            if (rightY != other.rightY)
                return false;
            return true;
        }

    }

    int max = 0;

    HashMap<Memo, Boolean> memoToCount = new HashMap<>();

    public int maximalSquareAlternate(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        calculateMaximalSquare(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);

        return max * max;
    }

    public boolean calculateMaximalSquare(char[][] matrix, int leftY, int rightY, int leftX, int rightX) {

        Memo memo = new Memo(leftY, rightY, leftX, rightX);

        if (memoToCount.containsKey(memo)) {
            return memoToCount.get(memo);
        }

        if (leftY > rightY || leftX > rightX) {
            return false;
        }

        if (leftY == rightY && leftX == rightX) {
            if (matrix[leftY][leftX] == '1') {
                max = Math.max(1, max);
                return true;
            }
            return false;
        }

        int yDiff = rightY - leftY;
        int xDiff = rightX - leftX;
        int minDiff = Math.min(yDiff, xDiff);
        boolean solution = true;
        if (xDiff == yDiff) {
            minDiff--;
        }
        int nextDiff = Math.max(0, minDiff);
        for (int y = leftY; y + nextDiff <= rightY; y++) {
            for (int x = leftX; x + nextDiff <= rightX; x++) {

                solution &= calculateMaximalSquare(matrix, y, y + nextDiff, x, x + nextDiff);

            }
        }

        if (solution) {
            if (xDiff == yDiff) {
                minDiff++;
            }
            max = Math.max(max, minDiff + 1);
        }

        memoToCount.put(memo, solution);

        return solution;

    }

    public int maximalSquare(char[][] matrix) {

        int max = 0;

        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];

        for (int y = 1; y <= matrix.length; y++) {
            for (int x = 1; x <= matrix[0].length; x++) {

                if (matrix[y - 1][x - 1] == '1') {
                    dp[y][x] = Math.min(Math.min(dp[y - 1][x], dp[y][x - 1]), dp[y - 1][x - 1]) + 1;
                    max = Math.max(max, dp[y][x]);
                }

            }
        }

        return max * max;
    }

    public static void main(String[] args) {

        // char[][] matrix = { { '1', '1' }, { '1', '1' }, { '0', '1' } };
        // char[][] matrix = { { '1', '1' }, { '1', '0' } };
        // char[][] matrix = { { '1', '1', '1', '1' }, { '1', '1', '1', '1' }, { '1',
        // '1', '1', '1' },
        // { '1', '1', '1', '1' } };
        // char[][] matrix = { { '1', '1' } };
        char[][] matrix = { { '1', '0', '1', '0' }, { '1', '0', '1', '1' }, { '1', '0', '1', '1' },
                { '1', '1', '1', '1' } };
        // char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
        // { '1', '1', '1', '1', '1' },
        // { '1', '0', '0', '1', '0' } };

        // char[][] matrix = { { '0', '1', '0' }, { '1', '1', '0' }, { '1', '1', '1' }
        // };
        // char[][] matrix = { { '1', '1', '1' }, { '1', '1', '1' }, { '1', '1', '1' }
        // };

        System.out.println(new MaximalSquare().maximalSquare(matrix));
    }

}