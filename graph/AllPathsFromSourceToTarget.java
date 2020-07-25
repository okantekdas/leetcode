package leetcode.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/*https://leetcode.com/problems/all-paths-from-source-to-target/*/
public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return allPathsSourceTarget(graph, 0);

    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph, int from) {

        List<List<Integer>> solution = new ArrayList<>();

        if (from == graph.length - 1) {
            List<Integer> subsolution = new ArrayList<>();
            subsolution.add(from);
            solution.add(subsolution);
            return solution;
        }

        for (int to = 0; to < graph[from].length; to++) {
            solution.addAll(allPathsSourceTarget(graph, graph[from][to]));
        }
        cartesianProduct(solution, from);
        return solution;

    }

    private void cartesianProduct(List<List<Integer>> solution, int from) {
        for (List<Integer> subsolution : solution) {
            subsolution.add(0, from);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};

        List<List<Integer>> solution = new AllPathsFromSourceToTarget().allPathsSourceTarget(graph);

        System.out.println(solution);

    }
}
