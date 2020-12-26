package leetcode.arrays;

import java.util.Arrays;

/* https://leetcode.com/problems/diagonal-traverse/ */
/* Runtime: 3 ms, faster than 54.26% Memory Usage: 40.8 MB, less than 83.42% */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int[] result = new int[matrix.length * matrix[0].length];

        int index = 0;

        int row = 0;
        int column = 0;

        // 1 is up, -1 is down
        int direction = 1;

        while (row < matrix.length && column < matrix[0].length) {

            result[index++] = matrix[row][column];

            int nextRow = row - direction;
            int nextColumn = column + direction;

            if (nextRow < 0 || nextRow == matrix.length || nextColumn < 0 || nextColumn == matrix[0].length) {
                if (direction == 1) {

                    if (nextColumn == matrix[0].length) {
                        nextRow += direction;
                        nextColumn -= direction;
                        nextRow++;
                    }

                    if (nextRow < 0) {
                        nextRow = 0;
                    }

                } else {
                    if (nextRow == matrix.length) {
                        nextRow += direction;
                        nextColumn -= direction;
                        nextColumn++;
                    }

                    if (nextColumn < 0) {
                        nextColumn = 0;
                    }
                }

                direction *= -1;
            }
            row = nextRow;
            column = nextColumn;

        }
        return result;

    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };

        System.out.println(Arrays.toString(new DiagonalTraverse().findDiagonalOrder(matrix)));
    }
}
