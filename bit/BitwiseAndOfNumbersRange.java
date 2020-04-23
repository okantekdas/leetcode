package leetcode.bit;

/* https://leetcode.com/problems/bitwise-and-of-numbers-range/ */
public class BitwiseAndOfNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }

        int i = 0;
        int result = 0;
        while (m > 0 && n > 0) {
            double divM = (double) m / 2;
            double divN = (double) n / 2;
            m /= 2;
            n /= 2;
            if (divN - divM < 1 && divN != n && divM != m) {
                result += 1 * Math.pow(2, i);

            }

            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int m = 0;
        int n = 1;

        System.out.println(new BitwiseAndOfNumbersRange().rangeBitwiseAnd(m, n));
    }

}