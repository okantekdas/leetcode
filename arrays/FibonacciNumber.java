package leetcode.arrays;

/* https://leetcode.com/problems/fibonacci-number/ */
/* Runtime: 0 ms, faster than 100.00% */
public class FibonacciNumber {
    private static final int SIZE = 31;
    private static final int[] memo = new int[SIZE];

    public int fib(int n) {

        memo[0] = 0;
        memo[1] = 1;
        if (n < 2) {
            return memo[n];
        }
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}
