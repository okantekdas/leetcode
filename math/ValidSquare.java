package leetcode.math;

import java.util.Arrays;

/* https://leetcode.com/problems/valid-square/ */
public class ValidSquare {

    public double distance(int[] p1, int[] p2) {
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        int[][] coordinates = { p1, p2, p3, p4 };

        Arrays.sort(coordinates, (v1, v2) -> v1[0] == v2[0] ? v1[1] - v2[1] : v1[0] - v2[0]);

        return distance(coordinates[0], coordinates[1]) != 0
                && distance(coordinates[0], coordinates[1]) == distance(coordinates[1], coordinates[3])
                && distance(coordinates[1], coordinates[3]) == distance(coordinates[3], coordinates[2])
                && distance(coordinates[3], coordinates[2]) == distance(coordinates[2], coordinates[0])
                && distance(coordinates[0], coordinates[3]) == distance(coordinates[1], coordinates[2]);

    }
}
