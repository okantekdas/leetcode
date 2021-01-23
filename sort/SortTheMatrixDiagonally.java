package leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* https://leetcode.com/problems/sort-the-matrix-diagonally/ */
/* Runtime: 7 ms, faster than 63.02% Memory Usage: 39.8 MB, less than 77.62%  */
public class SortTheMatrixDiagonally {

    public int[][] diagonalSort(int[][] mat) {

        // horizontal
        for (int x = 0; x < mat[0].length; x++) {

            List<Integer> diagonal = new ArrayList<>();

            int x2 = x;
            int y = 0;
            while (x2 < mat[0].length && y < mat.length) {
                diagonal.add(mat[y++][x2++]);
            }

            Collections.sort(diagonal);
            int dIndex = 0;
            x2 = x;
            y = 0;
            while (x2 < mat[0].length && y < mat.length) {
                mat[y++][x2++] = diagonal.get(dIndex++);
            }
        }

        // vertical
        for (int y = 1; y < mat.length; y++) {
            List<Integer> diagonal = new ArrayList<>();

            int y2 = y;
            int x = 0;
            while (x < mat[0].length && y2 < mat.length) {
                diagonal.add(mat[y2++][x++]);
            }

            Collections.sort(diagonal);
            int dIndex = 0;
            y2 = y;
            x = 0;
            while (x < mat[0].length && y2 < mat.length) {
                mat[y2++][x++] = diagonal.get(dIndex++);
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } };

        System.out.println(Arrays.deepToString(new SortTheMatrixDiagonally().diagonalSort(mat)));
    }

}
