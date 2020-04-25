package leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpressionAddOperators {

    public class Solution {
        int calculation;
        String value;

        public Solution(int calculation, String value) {
            this.calculation = calculation;
            this.value = value;
            if (calculation == globalTarget) {
                expressions.add(value);
            }
        }

    }

    List<String> expressions = new ArrayList<>();

    int globalTarget = 0;

    public List<String> addOperators(String num, int target) {
        globalTarget = target;
        calculateSolution(num, target);

        return expressions;
    }

    public List<Solution> calculateSolution(String num, int target) {

        List<Solution> solutions = new ArrayList<>();
        if (num.length() == 0) {
            return solutions;
        }
        solutions.add(new Solution(Integer.valueOf(num), num));

        for (int i = 1; i < num.length(); i++) {
            List<Solution> leftSolutions = calculateSolution(num.substring(0, i), target);
            List<Solution> rightSolutions = calculateSolution(num.substring(i, num.length()), target);
            cartesianProduct(leftSolutions, rightSolutions, solutions);
        }

        return solutions;
    }

    public void cartesianProduct(List<Solution> leftSolutions, List<Solution> rightSolutions,
            List<Solution> solutions) {

        for (Solution leftSolution : leftSolutions) {
            for (Solution rightSolution : rightSolutions) {
                solutions.add(new Solution(leftSolution.calculation + rightSolution.calculation,
                        leftSolution.value + "+" + rightSolution.value));
                solutions.add(new Solution(leftSolution.calculation - rightSolution.calculation,
                        leftSolution.value + "-" + rightSolution.value));
                solutions.add(new Solution(leftSolution.calculation * rightSolution.calculation,
                        leftSolution.value + "*" + rightSolution.value));
            }
        }
    }

    public static void main(String[] args) {
        String num = "105";
        int target = 5;

        List<String> solution = new ExpressionAddOperators().addOperators(num, target);
        System.out.println(Arrays.toString(solution.toArray()));
    }

}