package leetcode.backtracking;

import java.util.Arrays;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {

        solveSudoku(board, 0, 0);

    }

    public boolean solveSudoku(char[][] board, int y, int x) {
        if ((x >= board[0].length && y >= board.length) || y >= board.length) {
            return true;
        }

        if (x >= board[0].length) {
            return solveSudoku(board, y + 1, 0);
        }

        if (board[y][x] != '.') {
            return solveSudoku(board, y, x + 1);
        }

        for (int pickedNumber = 1; pickedNumber <= board[0].length; pickedNumber++) {
            char pickedChar = String.valueOf(pickedNumber).charAt(0);
            if (isValid(board, pickedChar, y, x)) {
                board[y][x] = pickedChar;
                if (solveSudoku(board, y, x + 1)) {
                    return true;
                }

                board[y][x] = '.';
            }
        }

        return false;

    }

    public boolean isValid(char board[][], char pickedChar, int y, int x) {

        for (int i = 0; i < board.length; i++) {
            if (board[i][x] == pickedChar) {
                return false;
            }
        }

        for (int i = 0; i < board[y].length; i++) {
            if (board[y][i] == pickedChar) {
                return false;
            }
        }

        int volumeX = x / 3;
        int volumeY = y / 3;

        for (int i = volumeY * 3; i < (volumeY + 1) * 3; i++) {
            for (int j = volumeX * 3; j < (volumeX + 1) * 3; j++) {
                if (board[i][j] == pickedChar) {
                    return false;
                }

            }

        }

        return true;
    }

    public static void main(String[] args) {

        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        new SudokuSolver().solveSudoku(board);
        System.out.println(Arrays.deepToString(board));

    }
}