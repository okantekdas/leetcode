package leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NonoverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

        int end = intervals[0][1];
        int eraseCount = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                eraseCount++;
            } else {
                end = intervals[i][1];
            }
        }

        return eraseCount;
    }

    public static void main(String[] args) {
        // int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        // int[][] intervals = { { 1, 5 }, { 2, 7 }, { 7, 8 } };
        int[][] intervals = { { 1, 100 }, { 1, 100 }, { 1, 99 }, { 11, 22 }, { 1, 11 }, { 2, 12 } };
        System.out.println(new NonoverlappingIntervals().eraseOverlapIntervals(intervals));
    }
}