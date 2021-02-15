package leetcode.arrays;

import java.util.Arrays;

/* https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/ */
/* Runtime: 1 ms, faster than 99.82% Memory Usage: 39.8 MB, less than 87.12% */
public class TheKWeakestRowsInMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {

        int[][] rows = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            int index = binarySearch(mat[i], 0, mat[i].length - 1);
            rows[i] = new int[] { index + 1, i };
        }

        Arrays.sort(rows, ((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]));

        int[] solution = new int[k];

        for (int i = 0; i < k; i++) {
            solution[i] = rows[rows.length - i - 1][1];
        }

        return solution;
    }

    int binarySearch(int[] row, int left, int right) {

        if (right < 0) {
            return left;
        }
        if (left >= row.length) {
            return right;
        }
        if (right - left == 1) {

            if (row[left] == 1 && row[right] == 1) {
                return right;
            } else if (row[left] == 1) {
                return left;
            } else {
                return -1;
            }
        }

        int mid = left + (right - left) / 2;

        if (row[mid] == 0) {
            return binarySearch(row, left, mid);
        }
        if (row[mid] == 1) {
            return binarySearch(row, mid, right);
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 } };
        System.out.println(Arrays.toString(new TheKWeakestRowsInMatrix().kWeakestRows(mat, 3)));
    }
}
