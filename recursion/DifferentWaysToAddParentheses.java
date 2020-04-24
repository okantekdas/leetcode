package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/different-ways-to-add-parentheses */
public class DifferentWaysToAddParentheses {

    static final char PLUS = '+';
    static final char MINUS = '-';
    static final char MULTIPLY = '*';

    public List<Integer> diffWaysToCompute(String input) {

        List<Integer> solutions = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == PLUS || input.charAt(i) == MINUS || input.charAt(i) == MULTIPLY) {
                List<Integer> leftSolutions = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightSolutions = diffWaysToCompute(input.substring(i + 1, input.length()));
                cartesianProduct(leftSolutions, input.charAt(i), rightSolutions, solutions);
            }

        }
        if (solutions.isEmpty()) {
            solutions.add(Integer.valueOf(input));
        }

        return solutions;
    }

    public void cartesianProduct(List<Integer> leftSolutions, char operator, List<Integer> rightSolutions,
            List<Integer> solutions) {

        for (int leftSolution : leftSolutions) {
            for (int rightSolution : rightSolutions) {
                if (operator == PLUS) {
                    solutions.add(leftSolution + rightSolution);
                } else if (operator == MINUS) {
                    solutions.add(leftSolution - rightSolution);
                } else if (operator == MULTIPLY) {
                    solutions.add(leftSolution * rightSolution);
                }
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(new DifferentWaysToAddParentheses().diffWaysToCompute("2*3-4*5"));

    }
}