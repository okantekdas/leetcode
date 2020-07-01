package leetcode.search;

/* https://leetcode.com/problems/arranging-coins/ */
public class ArrangingCoins {

    public int arrangeCoins(int n) {

        if (n == 0 || n == 1) {
            return n;
        }
        return arrangeCoins(n, 0, n);
    }

    public int arrangeCoins(int n, long left, long right) {
        if (left == right) {
            return (int) (left - 1);
        }

        long mid = left + (right - left) / 2;

        long calculation = (mid * mid + mid) / 2;

        if (calculation == n) {
            return (int) mid;
        }

        if (calculation < n) {
            return arrangeCoins(n, mid + 1, right);
        } else {
            return arrangeCoins(n, left, mid);
        }

    }

    public static void main(String[] args) {

        System.out.println(new ArrangingCoins().arrangeCoins(1804289383));
    }
}