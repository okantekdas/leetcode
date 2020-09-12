package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/combination-sum-iii/ */
public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {

        return combinationSum3(k, n, 1);
    }

    public List<List<Integer>> combinationSum3(int k, int n, int current) {
        List<List<Integer>> solution = new ArrayList<>();

        if (k == 0) {
            if (n > 0) {
                return null;
            } else if (n == 0) {
                solution = new ArrayList<>();
                solution.add(new ArrayList<>());
                return solution;
            }
        }

        for (int i = current; i <= 9; i++) {

            if (n - i >= 0) {
                List<List<Integer>> subsolution = combinationSum3(k - 1, n - i, i + 1);

                if (subsolution != null) {
                    for (List<Integer> s : subsolution) {
                        s.add(i);
                    }
                    if (subsolution.size() > 0) {
                        solution.addAll(subsolution);
                    }
                }
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 12;
        System.out.println(new CombinationSum3().combinationSum3(k, n));
    }
}
