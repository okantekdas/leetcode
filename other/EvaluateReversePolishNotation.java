package leetcode.other;

import java.util.Stack;

/* https://leetcode.com/problems/evaluate-reverse-polish-notation */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Stack<Integer> operandStack = new Stack<>();
        for (String s : tokens) {
            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                operandStack.push(Integer.valueOf(s));
            } else {
                if (s.equals("+")) {
                    int a = operandStack.pop();
                    int b = operandStack.pop();
                    operandStack.push(a + b);

                } else if (s.equals("-")) {
                    int a = operandStack.pop();
                    int b = operandStack.pop();
                    operandStack.push(b - a);

                } else if (s.equals("*")) {
                    int a = operandStack.pop();
                    int b = operandStack.pop();
                    operandStack.push(a * b);

                } else if (s.equals("/")) {
                    int a = operandStack.pop();
                    int b = operandStack.pop();
                    operandStack.push(b / a);
                }

            }
        }

        return operandStack.peek();
    }

    public static void main(String[] args) {

        // String[] tokens = { "4", "-2", "/", "2", "-3", "-", "-" };
        // String[] tokens = { "-100", "10", "/" };
        // String[] tokens = { "2", "1", "+", "3", "*" };
        String[] tokens = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        // String[] tokens = { "4", "13", "5", "/", "+" };

        System.out.println(new EvaluateReversePolishNotation().evalRPN(tokens));
    }

}