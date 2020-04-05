package leetcode.backtracking;

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

    public List<List<Integer>> calculateCombinations(int[] nums, int size, int index) {

        if (size == 0) {
            List<Integer> combination = new ArrayList<>();
            List<List<Integer>> combinations = new ArrayList<>();
            combinations.add(combination);
            return combinations;
        }

        List<List<Integer>> combinations = new ArrayList<>();
        for (int i = index; i < nums.length; i++) {
            List<List<Integer>> subCombinations = calculateCombinations(nums, size - 1, i + 1);

            for (List<Integer> subCombination : subCombinations) {

                List<Integer> copyOfSubCombination = new ArrayList<>();
                for (int value : subCombination) {
                    copyOfSubCombination.add(value);
                }

                copyOfSubCombination.add(nums[i]);
                combinations.add(copyOfSubCombination);

            }
            combinations.addAll(subCombinations);
        }

        return combinations;
    }

    final static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(new Combinations().combine(4, 2).toArray()));

    }

}