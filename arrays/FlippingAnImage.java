package leetcode.arrays;

import java.util.Arrays;

/* https://leetcode.com/problems/flipping-an-image */
/* Runtime: 0 ms, faster than 100.00% */
public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {

        int xLength = A.length;
        int yLength = A[0].length;
        for (int x = 0; x < xLength; x++) {
            for (int y = 0; y < yLength / 2; y++) {
                int right = A[x][yLength - y - 1];
                A[x][yLength - y - 1] = A[x][y] == 1 ? 0 : 1;
                A[x][y] = right == 1 ? 0 : 1;
            }

            if (yLength % 2 == 1) {
                A[x][yLength / 2] = A[x][yLength / 2] == 1 ? 0 : 1;
            }
        }

        return A;
    }

    public static void main(String[] args) {
        int[][] A = { { 1, 1, 0, 0 }, { 1, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 0, 1, 0 } };

        System.out.println(Arrays.deepToString(new FlippingAnImage().flipAndInvertImage(A)));

    }
}
