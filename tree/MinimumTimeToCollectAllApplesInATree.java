package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class MinimumTimeToCollectAllApplesInATree {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);

        }
        int result = calculateMinTime(graph, hasApple, 0, new boolean[n]);
        return result == Integer.MIN_VALUE ? 0 : result;

    }

    public int calculateMinTime(List<List<Integer>> graph, List<Boolean> hasApple, int currentNode,
            boolean[] isVisited) {

        int minTime = 0;
        isVisited[currentNode] = true;
        for (int edge : graph.get(currentNode)) {
            if (!isVisited[edge]) {
                int time = 2 + calculateMinTime(graph, hasApple, edge, isVisited);
                if (time >= 0) {
                    minTime += time;
                }
            }
        }

        if (!hasApple.get(currentNode) && minTime == 0) {
            minTime = Integer.MIN_VALUE;
        }

        return minTime;
    }

}