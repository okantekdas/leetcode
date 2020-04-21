package leetcode.other;

import java.util.List;

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

        while (0 <= x && y < n) {
            if (binaryMatrix.get(x, y) == 1) {
                x--;
            } else {
                y++;
            }
        }
        return x;
    }

}