package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* https://leetcode.com/problems/insert-interval/ */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> solution = new ArrayList<>();
        int[] interval = new int[2];
        int intervalIndex = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (intervalIndex == -1 && newInterval[0] < intervals[i][0]) {
                interval[0] = newInterval[0];
                interval[1] = newInterval[1];
                intervalIndex = solution.size();
                solution.add(interval);
                i--;
            } else if (newInterval[0] > intervals[i][1] || newInterval[1] < intervals[i][0]) {
                solution.add(intervals[i]);
            } else {
                if (newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1]) {
                    interval[0] = intervals[i][0];
                    if (intervals[i][1] >= newInterval[1]) {
                        interval[1] = intervals[i][1];
                    } else {
                        interval[1] = newInterval[1];
                    }
                    intervalIndex = solution.size();
                    solution.add(interval);
                } else if (newInterval[1] >= intervals[i][0] && newInterval[1] <= intervals[i][1]) {
                    solution.get(intervalIndex)[1] = intervals[i][1];
                }
            }

        }

        int size = intervalIndex == -1 ? solution.size() + 1 : solution.size();
        int[][] s = new int[size][2];

        for (int i = 0; i < solution.size(); i++) {
            s[i] = solution.get(i);
        }
        if (intervalIndex == -1) {
            if (s.length == 0) {
                s = new int[1][2];
                s[0] = newInterval;
            } else {
                s[s.length - 1] = newInterval;
            }
        }

        return s;
    }

    public static void main(String[] args) {

        // int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        // int[] newInterval = { 4, 8 };
        int[][] intervals = { { 1, 5 } };
        int[] newInterval = { 2, 3 };
        int[][] solution = new InsertInterval().insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(solution));
    }

}
