package leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* https://leetcode.com/problems/interval-list-intersections/ */
public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {

        int aLeft = 0;
        int bLeft = 0;

        List<int[]> solutionList = new ArrayList<>();
        while (aLeft < A.length && bLeft < B.length) {

            int[] a = A[aLeft];
            int[] b = B[bLeft];
            int[] intersection = new int[2];
            if (a[0] < b[0]) {
                if (a[1] < b[0]) {
                    // no intersection
                    aLeft++;
                } else {
                    if (b[1] < a[1]) {
                        intersection[0] = b[0];
                        intersection[1] = b[1];
                        bLeft++;
                    } else {
                        intersection[0] = b[0];
                        intersection[1] = a[1];
                        aLeft++;
                    }
                    solutionList.add(intersection);
                }

            } else {
                if (b[1] < a[0]) {
                    // no intersection
                    bLeft++;
                } else {
                    if (a[1] < b[1]) {
                        intersection[0] = a[0];
                        intersection[1] = a[1];
                        aLeft++;
                    } else {
                        intersection[0] = a[0];
                        intersection[1] = b[1];
                        bLeft++;
                    }
                    solutionList.add(intersection);
                }
            }

        }

        int[][] solutions = new int[solutionList.size()][];
        solutions = solutionList.toArray(solutions);

        return solutions;

    }

    public static void main(String[] args) {

        int[][] A = {};
        int[][] B = {};
        // int[][] A = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
        // int[][] B = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };

        int[][] solutions = new IntervalListIntersections().intervalIntersection(A, B);
        System.out.println(Arrays.deepToString(solutions));

    }
}