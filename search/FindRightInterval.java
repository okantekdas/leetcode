package leetcode.search;

import java.util.Arrays;

/* https://leetcode.com/problems/find-right-interval */
public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null) {
            return null;
        }

        int[][] modifiedIntervals = new int[intervals.length][3];
        for (int i = 0; i < intervals.length; i++) {
            modifiedIntervals[i][0] = i;
            if (intervals[i] == null) {
                return null;
            }
            modifiedIntervals[i][1] = intervals[i][0];
            modifiedIntervals[i][2] = intervals[i][1];
        }

        Arrays.sort(modifiedIntervals, (a, b) -> a[1] - b[1]);

        int[] solution = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int to = intervals[i][1];
            int nextIndex = binarySearch(to, modifiedIntervals, 0, modifiedIntervals.length - 1);
            solution[i] = nextIndex;

        }

        return solution;
    }

    private int binarySearch(int to, int[][] modifiedIntervals, int left, int right) {

        if (left >= modifiedIntervals.length || right < 0) {
            return -1;
        }
        if (left > right) {
            return modifiedIntervals[left][0];
        }
        int middle = left + (right - left) / 2;

        if (to == modifiedIntervals[middle][1]) {
            return modifiedIntervals[middle][0];
        } else if (to > modifiedIntervals[middle][1]) {
            return binarySearch(to, modifiedIntervals, middle + 1, right);
        } else {
            return binarySearch(to, modifiedIntervals, left, middle - 1);
        }

    }

    public static void main(String[] args) {
        // int[][] intervals = { { 1, 12 }, { 2, 9 }, { 3, 10 }, { 13, 14 }, { 15, 16 },
        // { 16, 17 } };
        int[][] intervals = { { 4, 5 }, { 2, 3 }, { 1, 2 } };
        System.out.println(Arrays.toString(new FindRightInterval().findRightInterval(intervals)));
    }
}