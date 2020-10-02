package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/combination-sum/ */
/* Runtime: 3 ms, faster than 80.27% Memory Usage: 39.4 MB, less than 86.59%*/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> solution = combinationSum(candidates, target, 0);
        return solution != null ? solution : new ArrayList<>();
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target, int index) {
        List<List<Integer>> solution = null;
        if (target == 0) {
            solution = new ArrayList<>();
            solution.add(new ArrayList<>());
            return solution;
        }
        if (index >= candidates.length || target < 0) {
            return null;
        }

        int max = target / candidates[index];
        for (int i = 0; i <= max; i++) {

            List<List<Integer>> subsolution = combinationSum(candidates, target - ((i + 1) * candidates[index]),
                    index + 1);
            if (subsolution != null) {
                for (List<Integer> s : subsolution) {
                    for (int j = 0; j <= i; j++) {
                        s.add(candidates[index]);
                    }

                }
                if (solution == null) {
                    solution = new ArrayList<>();
                }
                solution.addAll(subsolution);
            }

        }

        List<List<Integer>> subsolution = combinationSum(candidates, target, index + 1);

        if (subsolution != null) {
            if (solution == null) {
                solution = new ArrayList<>();
            }
            solution.addAll(subsolution);
        }

        return solution;

    }

    public static void main(String[] args) {

        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;

        List<List<Integer>> solution = new CombinationSum().combinationSum(candidates, target);

        int a = 5;
    }
}
