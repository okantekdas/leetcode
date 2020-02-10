package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FindEventualSafeStates
 */
public class FindEventualSafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        final List<Integer> solution = new ArrayList<>(graph.length);
        memo = new Boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (isEventualSafeNode(graph, i, new boolean[graph.length])) {
                solution.add(i);
            }
        }

        return solution;

    }

    public boolean isEventualSafeNode(int[][] graph, int current, boolean visited[]) {

        if(memo[current]!=null)
        {
            return memo[current];
        }

        if (visited[current]) {
            return false;
        }
        if (graph[current].length == 0) {
            return true;
        }

        boolean result = true;
        visited[current] = true;
        for (int neighbor : graph[current]) {
            result = isEventualSafeNode(graph, neighbor, visited);
            memo[neighbor] = result;
            if(!result)
            {
                break;
            }
        }
        memo[current] = result;

        return result;

    }

    static Boolean[] memo;

    public static void main(String[] args) {

        int[][] graph = new int[7][];

        graph[0] = new int[2];
        graph[0][0] = 1;
        graph[0][1] = 2;

        graph[1] = new int[2];
        graph[1][0] = 2;
        graph[1][1] = 3;

        graph[2] = new int[1];
        graph[2][0] = 5;

        graph[3] = new int[1];
        graph[3][0] = 0;

        graph[4] = new int[1];
        graph[4][0] = 5;

        graph[5] = new int[0];

        graph[6] = new int[0];

        System.out.println(Arrays.deepToString(graph));

        System.out.println(Arrays.toString(new FindEventualSafeStates().eventualSafeNodes(graph).toArray()));

    }
}