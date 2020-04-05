package leetcode.backtracking;

import java.util.Arrays;

public class NQueens2 {

    int totalSolutions = 0;

    public int totalNQueens(int n) {

        int[] chessboard = new int[n];
        Arrays.fill(chessboard, Integer.MIN_VALUE);
        nQueensCalculator(chessboard, 0, 0);

        return totalSolutions;
    }

    public void nQueensCalculator(int[] chessboard, int y, int totalPlacement) {

        if (y >= chessboard.length) {
            return;
        }

        for (int i = 0; i < chessboard.length; i++) {

            if (isSafeMove(chessboard, y, i)) {
                chessboard[y] = i;

                nQueensCalculator(chessboard, y + 1, totalPlacement + 1);

                if (totalPlacement + 1 == chessboard.length) {
                    totalSolutions++;
                }

                chessboard[y] = Integer.MIN_VALUE;
            }

            // recalculateOptions(chessboard, y, i, false);

        }

    }

    public boolean isSafeMove(int[] chessboard, int y, int x) {

        for (int i = 0; i < chessboard.length; i++) {
            if (chessboard[i] == x || i - chessboard[i] == y - x || i + chessboard[i] == y + x) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(new NQueens2().totalNQueens(5));

    }

}