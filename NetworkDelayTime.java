package leetcode;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.Lock;

class Edge {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

}

/**
 * NetworkDelayTime
 */
public class NetworkDelayTime {

    public static int networkDelayTime(int[][] times, int N, int K) {

        if (times == null || N < 1) {
            return -1;
        } else {

            HashMap<Integer, List<Edge>> fromToEdges = new HashMap<>();

            for (int[] time : times) {
                int from = time[0];
                int to = time[1];
                int weight = time[2];

                List<Edge> edges = fromToEdges.get(from);
                if (edges == null) {
                    edges = new ArrayList<>();
                    fromToEdges.put(from, edges);
                }
                edges.add(new Edge(to, weight));
            }


            int[] weightMatrix = new int[N];
            boolean[] visited = new boolean[N];
            Arrays.fill(weightMatrix, Integer.MAX_VALUE);

            int currentNode = K - 1;
            int previousTotal = 0;

            while (!visited[currentNode]) {
                List<Edge> currentEdges = fromToEdges.get(currentNode + 1);

                if (currentEdges != null) {
                    for (Edge edge : currentEdges) {
                        if (edge.weight + previousTotal < weightMatrix[edge.to - 1]) {
                            weightMatrix[edge.to - 1] = edge.weight + previousTotal;
                        }

                    }
                }

                visited[currentNode] = true;
                int smallest = Integer.MAX_VALUE;
                int smallestIndex = -1;
                boolean isAllVisited = true;
                for (int i = 0; i < weightMatrix.length; i++) {
                    if (!visited[i]) {
                        if (weightMatrix[i] < smallest) {
                            smallest = weightMatrix[i];
                            smallestIndex = i;
                        }
                        isAllVisited = false;
                    }
                }

                if (isAllVisited) {
                    return previousTotal;
                } else if (smallestIndex == -1) {
                    return -1;
                } else {
                    currentNode = smallestIndex;
                    previousTotal = smallest;
                }

            }

            return previousTotal;
        }
    }

    public static void main(String[] args) {

        // int[][] times = new int[3][3];
        // times[0][0] = 2;
        // times[0][1] = 1;
        // times[0][2] = 1;

        // times[1][0] = 2;
        // times[1][1] = 3;
        // times[1][2] = 1;

        // times[2][0] = 3;
        // times[2][1] = 4;
        // times[2][2] = 1;

        int[][] times = new int[1][3];
        times[0][0] = 1;
        times[0][1] = 2;
        times[0][2] = 1;

        System.out.println(networkDelayTime(times, 2, 2));
    }
}