package leetcode.recursion;

public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        return searchMatrix(matrix, target, 0, matrix[0].length - 1, 0, matrix.length - 1);

    }

    public boolean searchMatrix(int[][] matrix, int target, int x, int endX, int y, int endY) {

        if (x > endX || y > endY) {
            return false;
        }
        if (x == endX && y == endY) {
            return matrix[y][x] == target;
        }

        int midX = x + (endX - x) / 2;
        int midY = y + (endY - y) / 2;

        int midValue = matrix[midY][midX];

        if (target == midValue) {
            return true;
        }
        boolean solution = false;
        if (target < midValue) {
            solution |= searchMatrix(matrix, target, x, midX - 1, y, endY);
            if (solution) {
                return solution;
            }
            solution |= searchMatrix(matrix, target, x, endX, y, midY - 1);
        } else {

            solution |= searchMatrix(matrix, target, midX + 1, endX, y, endY);
            if (solution) {
                return solution;
            }
            solution |= searchMatrix(matrix, target, x, midX, y + 1, endY);
        }

        return solution;

    }

    public static void main(String[] args) {

        // int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16,
        // 22 }, { 10, 13, 14, 17, 24 },
        // { 18, 21, 23, 26, 30 } };
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };

        System.out.println("Result: " + new Search2DMatrix().searchMatrix(matrix, 9));

    }

}