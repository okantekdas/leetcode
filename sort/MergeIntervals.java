package leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* https://leetcode.com/problems/merge-intervals */
/* Runtime: 5 ms, faster than 94.10% Memory Usage: 41.6 MB, less than 65.17%*/
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[0] - a[0] : a[0] - b[0]);

        int startIndex = 0;
        int end = intervals[0][1];
        List<int[]> solution = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                int[] arr = new int[2];
                arr[0] = intervals[startIndex][0];
                arr[1] = end;
                solution.add(arr);

                startIndex = i;
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }
        }
        end = Math.max(end, intervals[intervals.length - 1][1]);
        int[] arr = new int[2];
        arr[0] = intervals[startIndex][0];
        arr[1] = end;
        solution.add(arr);
        int[][] s = new int[solution.size()][2];
        for (int i = 0; i < solution.size(); i++) {
            s[i] = solution.get(i);
        }

        return s;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 3, 3 }, { 0, 1 }, { 0, 0 } };
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(intervals)));
    }
}
