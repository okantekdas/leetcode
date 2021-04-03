package leetcode.dp;

/* https://leetcode.com/problems/ones-and-zeroes/ */
/* Runtime: 43 ms, faster than 56.86% */
public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {

        int[][] solution = new int[m + 1][n + 1];

        for (String str : strs) {
            int ones = 0;
            int zeroes = 0;

            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeroes++;
                } else {
                    ones++;
                }
            }

            int[][] subsolution = new int[m + 1][n + 1];

            for (int mIndex = 0; mIndex <= m; mIndex++) {
                for (int nIndex = 0; nIndex <= n; nIndex++) {

                    if (mIndex >= zeroes && nIndex >= ones) {

                        int remainingZeros = mIndex - zeroes;
                        int remainingOnes = nIndex - ones;
                        subsolution[mIndex][nIndex] = Math.max(solution[mIndex][nIndex],
                                solution[remainingZeros][remainingOnes] + 1);
                    } else {
                        subsolution[mIndex][nIndex] = solution[mIndex][nIndex];
                    }
                }
            }
            solution = subsolution;
        }
        return solution[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new OnesAndZeroes().findMaxForm(new String[] { "10", "0001", "111001", "1", "0" }, 5, 3));
    }
}
