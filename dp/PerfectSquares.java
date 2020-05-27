package leetcode.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/perfect-squares/ */
public class PerfectSquares {
    HashMap<Integer, Integer> numToSquares = new HashMap<>();

    // 430 ms
    public int numSquares(int n) {

        HashSet<Integer> visited = new HashSet<>();

        int biggestNum = (int) Math.sqrt(n);
        if (biggestNum * biggestNum == n) {
            return 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        int counter = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (visited.contains(current)) {
                    continue;
                }
                visited.add(current);
                if (current == 0) {
                    return counter;
                }

                biggestNum = (int) Math.sqrt(n);

                for (int j = biggestNum; j > 0; j--) {
                    queue.add(current - j * j);
                }

            }

            counter++;

        }

        return counter;
    }

    // 489 ms
    public int numSquaresAlternate(int n) {

        if (numToSquares.containsKey(n)) {
            return numToSquares.get(n);
        }

        int biggestNum = (int) Math.sqrt(n);
        if (biggestNum * biggestNum == n) {
            return 1;
        }

        int minResult = Integer.MAX_VALUE;
        for (int i = biggestNum; i > 0; i--) {
            int subresult = 1 + numSquaresAlternate(n - i * i);
            minResult = Math.min(minResult, subresult);
        }

        numToSquares.put(n, minResult);

        return minResult;
    }

    public static void main(String[] args) {

        System.out.println(new PerfectSquares().numSquares(16));

    }
}