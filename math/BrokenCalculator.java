package leetcode.math;

/* https://leetcode.com/problems/broken-calculator/ */
/* Runtime: 0 ms, faster than 100.00% Memory Usage: 35.6 MB, less than 83.46% */
public class BrokenCalculator {
    public int brokenCalc(int X, int Y) {
        int opCount = 0;

        while (Y > X) {
            if (Y % 2 == 0) {
                Y /= 2;
            } else {
                Y++;
            }
            opCount++;
        }

        return opCount + X - Y;
    }
}
