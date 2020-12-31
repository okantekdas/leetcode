package leetcode.arrays;

import java.util.Arrays;

/* https://leetcode.com/problems/game-of-life/ */
/* Runtime: 0 ms, faster than 100.00% Memory Usage: 37 MB, less than 98.39% */
public class GameOfLife {
    public void gameOfLife(int[][] board) {

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {

                int current = board[y][x];
                int neighbor = 0;

                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        int iY = i + y;
                        int iX = j + x;
                        if (iX >= 0 && iX < board[y].length && iY >= 0 && iY < board.length && (iX != x || iY != y)) {
                            if (Math.abs(board[iY][iX]) == 1) {
                                neighbor++;
                            }
                        }
                    }
                }
                if (current == 1 && (neighbor < 2 || neighbor > 3)) {
                    board[y][x] = -1;
                }

                if (current == 0 && neighbor == 3) {
                    board[y][x] = 2;
                }
            }
        }

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x] > 0) {
                    board[y][x] = 1;
                } else {
                    board[y][x] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        new GameOfLife().gameOfLife(board);
        System.out.println(Arrays.toString(board));
    }
}
