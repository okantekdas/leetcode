package leetcode.other;

import java.util.ArrayDeque;

/* https://leetcode.com/problems/basic-calculator */
public class BasicCalculator {

    int index = 0;

    public int calculate(String s) {

        ArrayDeque<Integer> operandDeque = new ArrayDeque<>();
        ArrayDeque<Character> operatorDeque = new ArrayDeque<>();

        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == '(') {
                // recurse
                index++;
                int current = calculate(s);
                if (!operatorDeque.isEmpty()) {
                    if (operatorDeque.peekLast() == '*') {
                        operatorDeque.removeLast();
                        int prev = operandDeque.removeLast();
                        operandDeque.add(prev * current);
                    } else if (operatorDeque.peekLast() == '/') {
                        operatorDeque.removeLast();
                        int prev = operandDeque.removeLast();
                        operandDeque.add(prev / current);
                    } else {
                        operandDeque.add(current);
                    }
                } else {
                    operandDeque.add(current);
                }
            } else if (c == ')') {
                // return
                index++;
                return calculateBasic(operandDeque, operatorDeque);
            } else if ((int) c < 58 && (int) c > 47) {
                // number
                int start = index;
                while ((int) c < 58 && (int) c > 47) {
                    index++;
                    if (index >= s.length()) {
                        break;
                    }
                    c = s.charAt(index);
                }
                index--;
                String operand = s.substring(start, index + 1);
                int current = Integer.valueOf(operand);
                if (!operatorDeque.isEmpty()) {
                    if (operatorDeque.peekLast() == '*') {
                        operatorDeque.removeLast();
                        int prev = operandDeque.removeLast();
                        operandDeque.add(prev * current);
                    } else if (operatorDeque.peekLast() == '/') {
                        operatorDeque.removeLast();
                        int prev = operandDeque.removeLast();
                        operandDeque.add(prev / current);
                    } else {
                        operandDeque.add(current);
                    }
                } else {
                    operandDeque.add(current);
                }
                index++;

            } else {
                // operator or space
                if (c != ' ') {
                    operatorDeque.add(c);
                }
                index++;
            }

        }

        return calculateBasic(operandDeque, operatorDeque);
    }

    public int calculateBasic(ArrayDeque<Integer> operandDeque, ArrayDeque<Character> operatorDeque) {
        while (operandDeque.size() > 1) {

            int first = operandDeque.pop();
            int second = operandDeque.pop();
            char operator = operatorDeque.pop();

            if (operator == '+') {
                operandDeque.push(first + second);
            } else {
                operandDeque.push(first - second);
            }
        }
        return operandDeque.peek();
    }

    public static void main(String[] args) {

        // System.out.println(new BasicCalculator().calculate("2-1 + 2 "));
        // System.out.println(new BasicCalculator().calculate("1 + 1"));
        // System.out.println(new BasicCalculator().calculate(" 2-1 + 2 "));
        System.out.println(new BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)"));
        // System.out.println(new BasicCalculator().calculate("(1+3)*(6+8)"));
    }

}