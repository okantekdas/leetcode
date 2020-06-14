package leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CheapestFlightsWithinKStops {
    HashMap<Integer, List<int[]>> srcToDst = new HashMap<>();

    int[][] memo;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        memo = new int[n][K + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        for (int[] flight : flights) {
            int source = flight[0];
            List<int[]> destinations = srcToDst.get(source);

            if (destinations == null) {
                destinations = new ArrayList<>();
                srcToDst.put(source, destinations);
            }

            int[] dest = { flight[1], flight[2] };
            destinations.add(dest);
        }

        return findCheapestPrice(src, dst, K);
    }

    public int findCheapestPrice(int src, int dst, int K) {
        if (src == dst) {
            return 0;
        }
        if (K < 0) {
            return -1;
        }

        if (memo[src][K] > -1) {
            return memo[src][K];
        }

        int minPrice = Integer.MAX_VALUE;

        List<int[]> destinations = srcToDst.get(src);
        if (destinations != null) {
            for (int[] destination : destinations) {
                int subsolution = findCheapestPrice(destination[0], dst, K - 1);
                if (subsolution > -1) {
                    subsolution += destination[1];
                    minPrice = Math.min(minPrice, subsolution);
                }
            }
        }

        memo[src][K] = minPrice == Integer.MAX_VALUE ? -1 : minPrice;

        return memo[src][K];
    }

    public static void main(String[] args) {

        int n = 5;
        int[][] flights = { { 0, 1, 5 }, { 1, 2, 5 }, { 0, 3, 2 }, { 3, 1, 2 }, { 1, 4, 1 }, { 4, 2, 1 } };
        int src = 0;
        int dst = 2;
        int K = 2;

        System.out.println(new CheapestFlightsWithinKStops().findCheapestPrice(n, flights, src, dst, K));
    }

}