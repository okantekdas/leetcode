package leetcode.other;

/* https://leetcode.com/problems/max-consecutive-ones-iii/ */
public class MaxConsecutiveOnes3 {

    public int longestOnes(int[] A, int K) {

        int left = 0;
        int right = 0;
        int max = 0;

        while (right < A.length) {
            int current = A[right];
            if (current == 1) {
                right++;
            } else {
                if (K > 0) {
                    K--;
                    right++;
                } else {
                    // max window found
                    int window = right - left;
                    if (window > max) {
                        max = window;
                    }

                    if (A[left] == 0) {
                        right++;
                    }
                    left++;
                }
            }

        }
        int window = right - left;
        if (window > max) {
            max = window;
        }

        return max;
    }

    public static void main(String[] args) {

        // int[] A = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        // int K = 3;
        int[] A = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int K = 2;
        // int[] A = { 0, 0, 0, 1 };
        // int K = 4;

        System.out.println(new MaxConsecutiveOnes3().longestOnes(A, K));

    }

}