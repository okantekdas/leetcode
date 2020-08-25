package leetcode.dp;

import java.util.HashMap;
import java.util.TreeSet;

public class MinimumCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        TreeSet<Integer> daysSet = new TreeSet<>();
        HashMap<Integer, Integer> dayToCost = new HashMap<>();

        for (int i = 0; i < days.length; i++) {
            daysSet.add(days[i]);
        }

        return mincostTickets(daysSet, costs, 1, dayToCost);
    }

    public int mincostTickets(TreeSet<Integer> daysSet, int[] costs, int day, HashMap<Integer, Integer> dayToCost) {

        if (day > daysSet.last()) {
            return 0;
        }

        int currentDay = 0;
        if (daysSet.contains(day)) {
            currentDay = day;
        } else {
            currentDay = daysSet.higher(day);
        }

        if (dayToCost.containsKey(currentDay)) {
            return dayToCost.get(currentDay);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < costs.length; i++) {
            int nextDay = 0;
            if (i == 0) {
                nextDay = currentDay + 1;
            } else if (i == 1) {
                nextDay = currentDay + 7;
            } else if (i == 2) {
                nextDay = currentDay + 30;
            }
            min = Math.min(min, costs[i] + mincostTickets(daysSet, costs, nextDay, dayToCost));
        }

        dayToCost.put(currentDay, min);
        return min;

    }

    public static void main(String[] args) {

        int[] days = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 };
        int[] costs = { 2, 7, 15 };

        System.out.println(new MinimumCostForTickets().mincostTickets(days, costs));
    }
}