package leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* https://leetcode.com/problems/expression-add-operators */
public class ExpressionAddOperators {

    List<String> expressions;

    List<String> solutions = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        expressions = calculateSolution(num);

        for (String expression : expressions) {
            String[] operandsStr = expression.split("[^0-9]");

            double subsolution = 0;
            if (operandsStr.length == 1) {
                subsolution = Double.valueOf(expression);
            } else {
                char[] operators = new char[operandsStr.length - 1];
                int count = 0;
                for (char c : expression.toCharArray()) {
                    if (c == '+' || c == '-' || c == '*') {
                        operators[count] = c;
                        count++;
                    }
                }

                int first = Integer.valueOf(operandsStr[0]);
                char prevOperator = ' ';
                subsolution = first;
                for (int i = 1; i < operandsStr.length; i++) {

                    char operator = operators[i - 1];
                    int second = Integer.valueOf(operandsStr[i]);

                    if (operator == '+') {
                        subsolution += second;
                    }
                    if (operator == '-') {
                        subsolution -= second;
                    }
                    if (operator == '*') {

                        if (prevOperator == '-') {
                            subsolution += first;
                            subsolution -= first * second;
                        } else {
                            subsolution -= first;
                            subsolution += first * second;
                        }

                    }

                    if (operator == '*') {
                        first = first * second;
                        if (prevOperator == '-') {
                            first *= -1;
                        }

                    } else {
                        first = second;
                    }

                    prevOperator = operator;

                }
            }

            if (subsolution == target) {
                solutions.add(expression);
            }

        }

        return solutions;
    }

    public List<String> calculateSolution(String num) {

        List<String> localExpressions = new ArrayList<>();

        if (num.isEmpty()) {
            return localExpressions;
        }

        if (num.length() > 1 && num.startsWith("0")) {
            // do nothing;
        } else {
            localExpressions.add(num);
        }
        for (int i = 1; i < num.length(); i++) {

            String currentNum = num.substring(0, i);
            if (currentNum.length() > 1 && currentNum.startsWith("0")) {
                continue;
            }
            String remaningNum = num.substring(i, num.length());
            List<String> remaningExpressions = calculateSolution(remaningNum);
            cartesianProduct(localExpressions, remaningExpressions, currentNum);
        }

        return localExpressions;

    }

    public void cartesianProduct(List<String> localExpressions, List<String> remaningExpressions, String currentNum) {

        for (String remaningExpression : remaningExpressions) {
            localExpressions.add(currentNum + "+" + remaningExpression);
            localExpressions.add(currentNum + "-" + remaningExpression);
            localExpressions.add(currentNum + "*" + remaningExpression);
        }

    }

    public static void main(String[] args) {
        String num = "000";
        int target = 0;

        List<String> solution = new ExpressionAddOperators().addOperators(num, target);
        System.out.println(Arrays.toString(solution.toArray()));
    }

}