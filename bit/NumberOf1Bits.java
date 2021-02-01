package leetcode.bit;

/* https://leetcode.com/problems/number-of-1-bits/submissions/ */
/* Runtime: 0 ms, faster than 100.00% */
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        int counter = 0;
        for (int i = 0; i < 32; i++) {
            if ((n >> i & 1) == 1) {
                counter++;
            }
        }

        return counter;
    }
}
