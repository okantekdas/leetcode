package leetcode.dp;

/* https://leetcode.com/problems/ugly-number-ii */
public class UglyNumbers2 {

    public int nthUglyNumber(int n) {

        int[] uglies = new int[n];
        uglies[0] = 1;

        int twoIndex = 0;
        int threeIndex = 0;
        int fiveIndex = 0;

        for (int i = 1; i < n; i++) {

            int twoMin = uglies[twoIndex] * 2;
            int threeMin = uglies[threeIndex] * 3;
            int fiveMin = uglies[fiveIndex] * 5;

            int min = Math.min(twoMin, Math.min(threeMin, fiveMin));
            if (min == twoMin) {
                twoIndex++;
            }
            if (min == threeMin) {
                threeIndex++;
            }
            if (min == fiveMin) {
                fiveIndex++;
            }
            uglies[i] = min;

        }

        return uglies[n - 1];

    }

}