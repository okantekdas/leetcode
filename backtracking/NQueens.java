package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    List<List<String>> solution = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        int[] chessboard = new int[n];
        Arrays.fill(chessboard, Integer.MIN_VALUE);
        nQueensCalculator(chessboard, 0, 0);

        return solution;

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
                    solution.add(constructGameBoard(chessboard));
                }

                chessboard[y] = Integer.MIN_VALUE;
            }

        }

    }

    public List<String> constructGameBoard(int[] chessboard) {
        List<String> boardAsList = new ArrayList<>();
        for (int i = 0; i < chessboard.length; i++) {
            char[] charArr = new char[chessboard.length];
            Arrays.fill(charArr, '.');
            if (chessboard[i] != Integer.MIN_VALUE) {
                charArr[chessboard[i]] = 'Q';
            }
            boardAsList.add(String.copyValueOf(charArr));
        }
        return boardAsList;
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

    }

}