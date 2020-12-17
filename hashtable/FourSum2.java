package leetcode.hashtable;

import java.util.HashMap;

/* https://leetcode.com/problems/4sum-ii/ */
/* Runtime: 59 ms, faster than 92.39% Memory Usage: 58.1 MB, less than 75.35% */
public class FourSum2 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> sumToCount = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[i];
                sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
            }
        }

        int solution = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[i];
                solution += sumToCount.getOrDefault(-1 * sum, 0);
            }
        }

        return solution;
    }
}
