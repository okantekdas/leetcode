package leetcode.math;

/* https://leetcode.com/problems/the-kth-factor-of-n/ */
/* Runtime: 0 ms, faster than 100.00% Memory Usage: 35.6 MB, less than 90.91% */
public class TheKthFactorOfN {

    public int kthFactor(int n, int k) {
        for (int i = 1; i < Math.sqrt(n); ++i) {
            if (n % i == 0 && --k == 0) {
                return i;
            }
        }

        for (int i = (int) Math.sqrt(n); i >= 1; --i) {
            if (n % i == 0 && --k == 0) {
                return n / i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new TheKthFactorOfN().kthFactor(1000, 8));
    }

}
