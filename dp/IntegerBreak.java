package leetcode.dp;

/* https://leetcode.com/problems/integer-break */
public class IntegerBreak {

    int[] solution = new int[58];

    public int integerBreak(int n) {

        if (n == 0 || n == 1) {
            return 0;
        }

        if (n == 2 || n == 3) {
            return n - 1;
        }

        if (solution[n - 1] != 0) {
            return solution[n - 1];
        }

        int max = n - 1;

        // iterated between 2 and 3 since maximal products are derive from these
        // multipliers

        /*
         * Now we know from maxima-minima concept that, If an integer need to break in
         * two parts, then to maximize their product those part should be equal. Using
         * this concept lets break n into (n/x) x’s then their product will be x(n/x),
         * now if we take derivative of this product and make that equal to 0 for
         * maxima, we will get to know that value of x should be e (base of the natural
         * logarithm) for maximum product. As we know that 2 < e < 3, so we should break
         * every Integer into 2 or 3 only for maximum product.
         */
        for (int i = 2; i < 4; i++) {
            max = Math.max(max, i * integerBreak(n - i));
            max = Math.max(max, i * (n - i));
        }

        solution[n - 1] = max;

        return max;
    }

    public static void main(String[] args) {

        int n = 58;

        System.out.println(new IntegerBreak().integerBreak(n));
    }

}