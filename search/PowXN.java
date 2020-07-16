package leetcode.search;

/* https://leetcode.com/problems/powx-n */
public class PowXN {
    public double myPow(double x, int n) {
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1 / (x * myPow(x, Integer.MAX_VALUE));
            } else {
                return 1 / myPow(x, -n);
            }

        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        }

        return x * myPow(x * x, n / 2);

    }

    public static void main(String[] args) {

        System.out.println(new PowXN().myPow(2, -2147483648));
    }
}