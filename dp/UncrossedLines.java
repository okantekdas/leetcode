package leetcode.dp;

import java.util.Arrays;

public class UncrossedLines {
    public int maxUncrossedLines(int[] A, int[] B) {

        int[][] memo = new int[A.length][];
        for (int i = 0; i < A.length; i++) {
            memo[i] = new int[B.length];
            Arrays.fill(memo[i], -1);
        }
        return calculateMaxUncrossedLines(A, B, 0, 0, memo);
    }

    public int calculateMaxUncrossedLines(int[] A, int[] B, int aIndex, int bIndex, int[][] memo) {
        if (aIndex == A.length || bIndex == B.length) {
            return 0;
        }

        int max = 0;
        for (int i = aIndex; i < A.length; i++) {
            int aVal = A[i];
            for (int j = bIndex; j < B.length; j++) {
                int bVal = B[j];
                if (aVal == bVal) {
                    max = Math.max(max, 1 + calculateMaxUncrossedLines(A, B, i + 1, j + 1, memo));

                }
            }
        }

        memo[aIndex][bIndex] = max;

        return max;
    }

    public static void main(String[] args) {

        // int[] A = { 2, 5, 1, 2, 5 };
        // int[] B = { 10, 5, 2, 1, 5, 2 };
        // int[] A = { 1, 3, 7, 1, 7, 5 };
        // int[] B = { 1, 9, 2, 5, 1 };
        int[] A = { 1, 1, 3, 5, 3, 3, 5, 5, 1, 1 };
        int[] B = { 2, 3, 2, 1, 3, 5, 3, 2, 2, 1 };

        System.out.println(new UncrossedLines().maxUncrossedLines(A, B));
    }
}