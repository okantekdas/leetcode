package leetcode.other;

/* https://leetcode.com/problems/check-if-it-is-a-straight-line */
public class CheckIfItIIsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {

        if (coordinates == null || coordinates.length < 2) {
            return false;
        }

        int firstX = coordinates[0][0];
        int firstY = coordinates[0][1];

        boolean xEqual = false;
        if (coordinates[1][0] - firstX == 0) {
            xEqual = true;
        }
        boolean yEqual = false;
        if (coordinates[1][1] - firstY == 0) {
            yEqual = true;
        }

        float slope = 0;
        if (!xEqual && !yEqual) {
            slope = (coordinates[1][0] - firstX) / (coordinates[1][1] - firstY);
        }

        for (int i = 2; i < coordinates.length; i++) {
            int localCoordinate[] = coordinates[i];
            if (xEqual && localCoordinate[0] - firstX != 0) {
                return false;
            }
            if (yEqual && localCoordinate[1] - firstY != 0) {
                return false;
            }

            if (!xEqual && !yEqual) {
                if (localCoordinate[0] - firstX == 0 || localCoordinate[1] - firstY == 0) {
                    return false;
                }
                if ((localCoordinate[0] - firstX) / (localCoordinate[1] - firstY) != slope) {
                    return false;
                }

            }
        }

        return true;

    }

    public static void main(String[] args) {
        // int[][] coordinates = { { 1, 1 }, { 2, 2 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, {
        // 7, 7 } };
        // int[][] coordinates = { { -3, -2 }, { -1, -2 }, { 2, -2 }, { -2, -2 }, { 0,
        // -2 } };
        int[][] coordinates = { { -7, -3 }, { -7, -1 }, { -2, -2 }, { 0, -8 }, { 2, -2 }, { 5, -6 }, { 5, -5 },
                { 1, 7 } };

        System.out.println(new CheckIfItIIsAStraightLine().checkStraightLine(coordinates));
    }
}