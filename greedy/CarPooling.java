package leetcode.greedy;

import java.util.HashMap;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {

        HashMap<Integer, Integer> destToPassanger = new HashMap<>();

        int prevStart = 0;
        for (int[] trip : trips) {

            int passenger = trip[0];
            int start = trip[1];
            int end = trip[2];
            capacity -= passenger;
            for (int i = prevStart; i <= start; i++) {
                Integer passangers = destToPassanger.get(i);

                if (passangers != null) {
                    destToPassanger.remove(i);
                    capacity += passangers;
                }
            }

            if (capacity < 0) {
                return false;
            }

            Integer endPassanger = destToPassanger.get(end);
            if (endPassanger == null) {
                endPassanger = 0;
            }
            destToPassanger.put(end, endPassanger + passenger);
            prevStart = start;

        }

        return true;
    }

    public static void main(String[] args) {

        int[][] trips = { { 7, 5, 6 }, { 6, 7, 8 }, { 10, 1, 6 } };
        int capacity = 16;
        System.out.println(new CarPooling().carPooling(trips, capacity));

    }
}
