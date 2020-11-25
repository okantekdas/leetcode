package leetcode.math;

/* https://leetcode.com/problems/smallest-integer-divisible-by-k/ */
/* Runtime: 2 ms, faster than 74.03% */
public class SmallestIntegerDivisibleByK {
    public int smallestRepunitDivByK(int K) {
        int remainder = 0;
        for (int solution = 1; solution <= K; solution++) {
            remainder = (remainder * 10 + 1) % K;
            if (remainder == 0) {
                return solution;
            }
        }
        return -1;
    }
}
