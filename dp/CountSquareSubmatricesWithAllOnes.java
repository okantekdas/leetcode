package leetcode.dp;

/* https://leetcode.com/problems/count-square-submatrices-with-all-ones */
public class CountSquareSubmatricesWithAllOnes {

    public int countSquares(int[][] matrix) {

        int count = 0;
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (matrix[y][x] == 1) {
                    if (y != 0 && x != 0) {
                        int min = Math.min(matrix[y - 1][x - 1], Math.min(matrix[y - 1][x], matrix[y][x - 1])) + 1;
                        matrix[y][x] = min;
                        count += min;
                    } else {
                        count++;
                    }

                }

            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[][] matrix = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };

        System.out.println(new CountSquareSubmatricesWithAllOnes().countSquares(matrix));

    }

}