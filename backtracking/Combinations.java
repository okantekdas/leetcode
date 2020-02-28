package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combinations
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {

        return combine(n, k, 1, null);

    }

    public List<List<Integer>> combine(int n, int k, int current, List<Integer> solution) {

        if (solution == null) {
            solution = new ArrayList<>();
        }
        if (solution.size() == k) {
            result.add(solution);
        } else {
            for (int i = current; i <= n; i++) {
                List<Integer> currentSolution = new ArrayList<>(solution);
                currentSolution.add(i);
                combine(n, k, i + 1, currentSolution);
            }
        }

        return result;
    }

    final static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(new Combinations().combine(4, 2).toArray()));

    }

}