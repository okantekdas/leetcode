package leetcode.other;

import java.util.Arrays;

/* https://leetcode.com/problems/sort-array-by-parity */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        if (A.length == 1) {
            return A;
        }

        int left = 0;
        int right = 1;

        while (right < A.length) {
            if (A[left] % 2 == 1) {
                // wait for right to find even and swap
                if (A[right] % 2 == 0) {
                    // swap
                    int temp = A[right];
                    A[right] = A[left];
                    A[left] = temp;
                    right++;
                } else {
                    // go on
                    right++;
                }
            } else {
                // go on
                left++;
            }

            if (left == right) {
                right++;
            }

        }

        return A;
    }

    public static void main(String[] args) {
        int[] A = { 8, 3, 1, 2, 4 };
        System.out.println(Arrays.toString(new SortArrayByParity().sortArrayByParity(A)));
    }
}