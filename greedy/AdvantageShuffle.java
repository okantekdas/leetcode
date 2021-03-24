package leetcode.greedy;

import java.util.Arrays;

/* https://leetcode.com/problems/advantage-shuffle/ */
/* Runtime: 28 ms, faster than 83.54% */
public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {

        Arrays.sort(A);
        int[][] sortedB = new int[B.length][2];
        int index = 0;

        for (int b : B) {
            sortedB[index] = new int[] { b, index++ };
        }

        Arrays.sort(sortedB, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });

        int[] solution = new int[A.length];
        int aRightIndex = A.length - 1;
        int aLeftIndex = 0;

        for (int bLeftIndex = sortedB.length - 1; bLeftIndex >= 0; bLeftIndex--) {
            if (sortedB[bLeftIndex][0] >= A[aRightIndex]) {
                solution[sortedB[bLeftIndex][1]] = A[aLeftIndex++];
            } else {
                solution[sortedB[bLeftIndex][1]] = A[aRightIndex--];
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new AdvantageShuffle().advantageCount(new int[] { 12, 24, 8, 32 }, new int[] { 13, 25, 32, 11 })));
    }
}
