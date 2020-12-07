package leetcode.arrays;

import java.util.Arrays;

/* https://leetcode.com/problems/spiral-matrix-ii/ */
/* Runtime: 0 ms, faster than 100.00% Memory Usage: 36.9 MB, less than 77.63% */
public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int left = 0;
        int right = n - 1;
        int current = 0;
        int target = (int) Math.pow(n, 2);
        while (current <= target) {

            if (current + 1 == target) {
                matrix[left][left] = ++current;
                break;
            }

            current = fillLeftToRight(matrix, current, left, left, right - 1);
            if (current == target) {
                break;
            }
            current = fillTopToDown(matrix, current, right, left, right - 1);
            current = fillRightToLeft(matrix, current, right, left + 1, right);
            current = fillDownToTop(matrix, current, left, left + 1, right);

            left++;
            right--;
        }

        return matrix;
    }

    private int fillDownToTop(int[][] matrix, int prev, int column, int low, int high) {

        for (int i = high; i >= low; i--) {
            matrix[i][column] = ++prev;
        }

        return prev;
    }

    private int fillRightToLeft(int[][] matrix, int prev, int row, int low, int high) {
        for (int i = high; i >= low; i--) {
            matrix[row][i] = ++prev;
        }

        return prev;
    }

    private int fillTopToDown(int[][] matrix, int prev, int column, int low, int high) {
        for (int i = low; i <= high; i++) {
            matrix[i][column] = ++prev;
        }

        return prev;
    }

    private int fillLeftToRight(int[][] matrix, int prev, int row, int low, int high) {
        for (int i = low; i <= high; i++) {
            matrix[row][i] = ++prev;
        }

        return prev;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(new SpiralMatrix2().generateMatrix(5)));
    }
}
