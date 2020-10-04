package leetcode.sort;

import java.util.Arrays;

/* https://leetcode.com/problems/remove-covered-intervals/ */
/* Runtime: 4 ms, faster than 97.46% Memory Usage: 39.8 MB, less than 50.76%*/
public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals.length == 1) {
            return 1;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0] == 0 ? b[1] - a[1] : a[0] - b[0]);

        int left = 0;
        int right = 1;

        int counter = intervals.length;
        while (right < intervals.length) {
            if (intervals[left][0] <= intervals[right][0]) {
                if (intervals[left][1] >= intervals[right][1]) {
                    counter--;
                } else {
                    left = right;
                }
            } else {
                left++;
            }
            right++;
        }

        return counter;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 34, 39 }, { 15, 91 }, { 29, 66 }, { 53, 69 }, { 40, 93 } };
        System.out.println(new RemoveCoveredIntervals().removeCoveredIntervals(intervals));
    }
}
