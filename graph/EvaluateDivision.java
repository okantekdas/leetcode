package leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* https://leetcode.com/problems/evaluate-division/ */
public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

        int index = 0;
        for (List<String> route : equations) {
            String from = route.get(0);
            String to = route.get(1);

            HashMap<String, Double> fromNeighbors = graph.get(from);
            if (fromNeighbors == null) {
                fromNeighbors = new HashMap<>();
                graph.put(from, fromNeighbors);

            }
            fromNeighbors.put(to, values[index]);
            graph.put(from, fromNeighbors);

            HashMap<String, Double> toNeighbors = graph.get(to);
            if (toNeighbors == null) {
                toNeighbors = new HashMap<>();
                graph.put(to, toNeighbors);

            }
            toNeighbors.put(from, 1 / values[index]);
            graph.put(to, toNeighbors);
            index++;
        }

        double[] solution = new double[queries.size()];

        for (int i = 0; i < solution.length; i++) {
            List<String> query = queries.get(i);
            double subsolution = -1;
            if (graph.containsKey(query.get(0)) && graph.containsKey(query.get(1))) {
                subsolution = dfs(query.get(0), query.get(1), graph, new HashSet<>());
                if (subsolution == 0) {
                    subsolution = -1;
                }

            }

            solution[i] = subsolution;

        }

        return solution;
    }

    public double dfs(String from, String to, HashMap<String, HashMap<String, Double>> graph, Set<String> visited) {
        HashMap<String, Double> neighbors = graph.get(from);
        if (neighbors != null && neighbors.containsKey(to)) {
            return neighbors.get(to);
        }

        if (visited.contains(from)) {
            return 0;
        }
        if (from.equals(to)) {
            return 1;

        }

        visited.add(from);
        double solution = 0;
        if (neighbors != null) {

            for (String dest : neighbors.keySet()) {
                double value = neighbors.get(dest);

                solution = value * dfs(dest, to, graph, visited);
                if (solution != 0) {

                    graph.get(from).put(to, solution);
                    break;
                }
            }
        }
        visited.remove(from);

        return solution;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = { 2.0, 3.0 };
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));

        System.out.println(Arrays.toString(new EvaluateDivision().calcEquation(equations, values, queries)));

    }
}
