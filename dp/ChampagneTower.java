package leetcode.dp;

/* https://leetcode.com/problems/champagne-tower/ */
/* Runtime: 4 ms, faster than 66.89% */
public class ChampagneTower {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] A = new double[101][101];
        A[0][0] = (double) poured;
        for (int row = 0; row <= query_row; ++row) {
            for (int column = 0; column <= row; ++column) {
                double localPour = (A[row][column] - 1.0) / 2.0;
                if (localPour > 0) {
                    A[row + 1][column] += localPour;
                    A[row + 1][column + 1] += localPour;
                }
            }
        }
        return Math.min(1, A[query_row][query_glass]);
    }

    public static void main(String[] args) {
        int poured = 1000000000;
        int query_row = 99;
        int query_glass = 99;

        System.out.println(new ChampagneTower().champagneTower(poured, query_row, query_glass));

    }

}
