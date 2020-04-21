package leetcode.other;

import java.util.List;

/* https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3306/ */
public class LeftmostColumnWithAtLeastOne {

    interface BinaryMatrix {
        public int get(int x, int y);

        public List<Integer> dimensions();
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {

        List<Integer> dimensions = binaryMatrix.dimensions();
        int n = dimensions.get(0);
        int m = dimensions.get(1);

        int y = 0;
        int x = m - 1;

        int solution = -1;
        while (0 <= x && y < n) {
            System.out.println("x:" + x + " y:" + y);
            if (binaryMatrix.get(y, x) == 1) {
                solution = x;
                x--;
            } else {
                y++;
            }
        }
        return solution;
    }

}