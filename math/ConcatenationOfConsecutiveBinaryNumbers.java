package leetcode.math;

/* https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/ */
/* Runtime: 491 ms, faster than 41.33% */
public class ConcatenationOfConsecutiveBinaryNumbers {
    static int MOD = 1_000_000_007;

    /* a(n) = a(n-1) * 2^(1 + floor(log2(n))) + n */
    public int concatenatedBinary(int n) {

        if (n == 1) {
            return 1;
        }

        return (int) ((concatenatedBinary(n - 1) * Math.pow(2, 1 + Math.floor(logN(n, 2))) + n) % MOD);

    }

    public double logN(int num, int logBase) {
        return Math.log(num) / Math.log(logBase);
    }

}
