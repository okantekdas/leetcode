package leetcode.math;

import java.util.Arrays;

/* https://leetcode.com/problems/numbers-at-most-n-given-digit-set/ */
/* Runtime: 1 ms, faster than 58.12% Memory Usage: 35.8 MB, less than 99.15% */
public class NumbersAtMostNGivenDigitSet {
    public int atMostNGivenDigitSet(String[] digits, int n) {

        int[] digitsNum = new int[digits.length];

        int i = 0;
        for (String digit : digits) {
            digitsNum[i++] = Integer.valueOf(digit);
        }
        Arrays.sort(digitsNum);
        int count = 0;
        int length = String.valueOf(n).length();
        for (i = 1; i < length; i++) {
            count += Math.pow(digits.length, i);
        }

        int sum = -1;

        for (i = 0; i < length; i++) {
            int currentDigit = n % 10;
            int smallerCount = 0;
            int j = 0;
            boolean isSame = false;
            for (; j < digitsNum.length; j++) {

                if (currentDigit == digitsNum[j]) {
                    smallerCount++;
                    isSame = true;
                    break;
                } else if (currentDigit < digitsNum[j]) {
                    break;
                } else {
                    smallerCount++;
                }
            }
            n -= currentDigit;
            n /= 10;

            if (sum == -1) {
                sum = smallerCount;
            } else {
                if (smallerCount == 0) {
                    sum = 0;
                } else {
                    if (isSame) {
                        sum = (int) Math.pow(digitsNum.length, i) * (smallerCount - 1) + sum;
                    } else {
                        sum = (int) Math.pow(digitsNum.length, i) * smallerCount;
                    }
                }
            }
        }
        return count + sum;
    }

    public static void main(String[] args) {
        String[] digits = { "2", "3", "4", "6", "8" };
        int n = 61;

        System.out.println(new NumbersAtMostNGivenDigitSet().atMostNGivenDigitSet(digits, n));
    }
}
