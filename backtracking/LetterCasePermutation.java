package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/* https://leetcode.com/problems/letter-case-permutation/ */
/* Runtime: 3 ms, faster than 62.51% Memory Usage: 39.8 MB, less than 68.40% */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {

        if (S == null || S.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> subSolution = letterCasePermutation(S.substring(1));
        List<String> solution = new ArrayList<>();
        char current = S.charAt(0);
        for (String str : subSolution) {
            solution.add(String.valueOf(current) + str);
            if (current > 64 && current < 91) {
                solution.add(String.valueOf((char) (current + 32)) + str);
            } else if (current > 96 && current < 123) {
                solution.add(String.valueOf((char) (current - 32)) + str);
            }
        }

        if (solution.isEmpty()) {
            solution.add(String.valueOf(current));
            if (current > 64 && current < 91) {
                solution.add(String.valueOf((char) (current + 32)));
            } else if (current > 96 && current < 123) {
                solution.add(String.valueOf((char) (current - 32)));
            }
        }

        return solution;
    }

    public static void main(String[] args) {
        List<String> solution = new LetterCasePermutation().letterCasePermutation("3z4");
        solution.forEach(new Consumer<String>() {

            @Override
            public void accept(String arg0) {
                System.out.println(arg0);
            }

        });
    }
}
