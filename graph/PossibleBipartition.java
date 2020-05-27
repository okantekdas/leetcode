package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* https://leetcode.com/problems/possible-bipartition/submissions/ */
public class PossibleBipartition {

    /*
     * Runtime: 23 ms, faster than 57.42% Memory Usage: 47.4 MB, less than 100.00%
     */
    public boolean possibleBipartition(int N, int[][] dislikes) {
        HashMap<Integer, List<Integer>> nodeToDislikeNodes = new HashMap<>();
        int[] colors = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int[] dislike : dislikes) {
            int firstNode = dislike[0];
            int secondNode = dislike[1];

            List<Integer> dislikeNodes = nodeToDislikeNodes.get(firstNode);

            if (dislikeNodes == null) {
                dislikeNodes = new ArrayList<>();
                nodeToDislikeNodes.put(firstNode, dislikeNodes);
            }
            dislikeNodes.add(secondNode);

            dislikeNodes = nodeToDislikeNodes.get(secondNode);

            if (dislikeNodes == null) {
                dislikeNodes = new ArrayList<>();
                nodeToDislikeNodes.put(secondNode, dislikeNodes);
            }
            dislikeNodes.add(firstNode);

        }

        boolean result = true;
        for (int i = 1; i <= N; i++) {
            result &= dfs(i, dislikes, visited, nodeToDislikeNodes, colors);
        }

        return result;
    }

    public boolean dfs(int current, int[][] dislikes, boolean[] visited,
            HashMap<Integer, List<Integer>> nodeToDislikeNodes, int[] colors) {

        if (visited[current]) {
            return true;
        }

        if (!nodeToDislikeNodes.containsKey(current)) {
            return true;
        }

        visited[current] = true;
        if (colors[current] == 0) {
            colors[current] = 1;
        }
        int color = colors[current];
        boolean solution = true;
        for (int dislike : nodeToDislikeNodes.get(current)) {
            if (color == colors[dislike]) {
                return false;
            }
            colors[dislike] = -color;

            solution &= dfs(dislike, dislikes, visited, nodeToDislikeNodes, colors);

        }
        return solution;

    }

    /* 179 ms */
    public boolean possibleBipartitionAlternate(int N, int[][] dislikes) {

        HashMap<Integer, List<Integer>> nodeToDislikeNodes = new HashMap<>();

        Queue<Integer> queue = new LinkedList<>();
        int[] color = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int[] dislike : dislikes) {
            int firstNode = dislike[0];
            int secondNode = dislike[1];

            List<Integer> dislikeNodes = nodeToDislikeNodes.get(firstNode);

            if (dislikeNodes == null) {
                dislikeNodes = new ArrayList<>();
                nodeToDislikeNodes.put(firstNode, dislikeNodes);
            }
            dislikeNodes.add(secondNode);

            dislikeNodes = nodeToDislikeNodes.get(secondNode);

            if (dislikeNodes == null) {
                dislikeNodes = new ArrayList<>();
                nodeToDislikeNodes.put(secondNode, dislikeNodes);
            }
            dislikeNodes.add(firstNode);

        }

        for (int i = 1; i <= N;) {

            if (queue.isEmpty()) {
                if (!visited[i]) {
                    queue.add(i);
                }
                i++;
            }

            int size = queue.size();

            for (int j = 0; j < size; j++) {
                int currentNode = queue.poll();
                visited[currentNode] = true;
                if (color[currentNode] == 0) {
                    color[currentNode] = 1;
                }

                if (nodeToDislikeNodes.containsKey(currentNode)) {
                    for (int dislike : nodeToDislikeNodes.get(currentNode)) {

                        if (!visited[dislike]) {
                            if (color[dislike] == color[currentNode]) {
                                return false;
                            }
                            color[dislike] = -color[currentNode];
                            queue.add(dislike);
                        }

                    }
                }

            }
        }

        return true;
    }

    public static void main(String[] args) {
        int N = 3;

        int[][] dislikes = { { 1, 2 }, { 1, 3 }, { 2, 3 } };

        System.out.println(new PossibleBipartition().possibleBipartition(N, dislikes));
    }
}