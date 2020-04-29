package leetcode.dp;

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