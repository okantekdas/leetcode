package leetcode.dp;

import java.util.HashMap;

/* https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/ */
/* Runtime: 148 ms, faster than 39.75% Memory Usage: 39.7 MB, less than 70.86% */
public class NumberOfSubmatricesThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 1; x < matrix[y].length; x++) {
                matrix[y][x] += matrix[y][x - 1];
            }
        }

        int solution = 0;
        for (int l = 0; l < matrix[0].length; l++) {
            for (int r = l; r < matrix[0].length; r++) {
                HashMap<Integer, Integer> sumToSolution = new HashMap<>();
                sumToSolution.put(0, 1);
                int sum = 0;
                for (int y = 0; y < matrix.length; y++) {
                    sum += matrix[y][r] - (l > 0 ? matrix[y][l - 1] : 0);
                    solution += sumToSolution.getOrDefault(sum - target, 0);
                    sumToSolution.put(sum, sumToSolution.getOrDefault(sum, 0) + 1);
                }
            }
        }

        return solution;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 0, 1, 0 }, { 1, 1, 1 }, { 0, 1, 0 } };

        System.out.println(new NumberOfSubmatricesThatSumToTarget().numSubmatrixSumTarget(matrix, 0));
    }
}
