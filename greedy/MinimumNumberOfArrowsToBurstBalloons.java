package leetcode.greedy;

import java.util.Arrays;

/* https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons */
/* Runtime: 14 ms, faster than 99.81% Memory Usage: 46.8 MB, less than 17.36% */
public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        // main idea is to sort by end points and check for the overlapping
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int end = points[0][1];
        int overlapping = 0;
        for (int i = 1; i < points.length; i++) {
            if (end >= points[i][0]) {
                overlapping++;
            } else {
                end = points[i][1];
            }
        }

        return points.length - overlapping;

    }

    public static void main(String[] args) {
        int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 19 }, { 7, 12 } };

        System.out.println(new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(points));
    }
}
