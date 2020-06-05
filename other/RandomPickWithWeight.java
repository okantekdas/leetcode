package leetcode.other;

import java.util.Arrays;

/* https://leetcode.com/problems/random-pick-with-weight */
public class RandomPickWithWeight {

    class Solution {

        int[] w = null;
        double[] probabilities = null;

        public Solution(int[] w) {
            this.w = w;
            probabilities = new double[w.length];

            int sum = 0;
            for (int i = 0; i < w.length; i++) {
                sum += w[i];
            }
            for (int i = 0; i < w.length; i++) {

                // calculate distribution
                w[i] += i == 0 ? 0 : w[i - 1];
                probabilities[i] = w[i] / sum;

            }

            Arrays.sort(probabilities);

        }

        public int pickIndex() {

            return Math.abs(Arrays.binarySearch(probabilities, Math.random())) - 1;
        }
    }
}
