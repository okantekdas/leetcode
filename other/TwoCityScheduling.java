package leetcode.other;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TwoCityScheduling {

    class Cost {
        int personNum;
        int diff;
        boolean isASmaller;

        public Cost(int personNum, int diff, boolean isASmaller) {
            this.personNum = personNum;
            this.diff = diff;
            this.isASmaller = isASmaller;
        }

    }

    public int twoCitySchedCost(int[][] costs) {

        PriorityQueue<Cost> queue = new PriorityQueue<>(new Comparator<Cost>() {

            @Override
            public int compare(Cost o1, Cost o2) {
                if (o1.diff < o2.diff) {
                    return 1;
                } else if (o1.diff > o2.diff) {
                    return -1;
                }
                return 0;
            }
        });

        int personNum = 0;
        for (int[] person : costs) {
            int cityCost1 = person[0];
            int cityCost2 = person[1];
            queue.add(new Cost(personNum++, Math.abs(cityCost1 - cityCost2), cityCost1 < cityCost2 ? true : false));
        }

        int cityANum = 0;
        int cityBNum = 0;
        int total = 0;
        while (!queue.isEmpty()) {
            Cost cost = queue.poll();
            if (cost.isASmaller) {
                if (cityANum < costs.length / 2) {
                    total += costs[cost.personNum][0];
                    cityANum++;
                } else {
                    total += costs[cost.personNum][1];
                    cityBNum++;
                }

            } else {
                if (cityBNum < costs.length / 2) {
                    total += costs[cost.personNum][1];
                    cityBNum++;
                } else {
                    total += costs[cost.personNum][0];
                    cityANum++;
                }
            }
        }

        return total;
    }

    public static void main(String[] args) {

        int[][] costs = { { 259, 770 }, { 448, 54 }, { 926, 667 }, { 184, 139 }, { 840, 118 }, { 577, 469 } };
        System.out.println(new TwoCityScheduling().twoCitySchedCost(costs));

    }

}