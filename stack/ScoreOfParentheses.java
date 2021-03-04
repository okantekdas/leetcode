package leetcode.stack;

import java.util.Stack;

/* https://leetcode.com/problems/score-of-parentheses/ */
/* Runtime: 0 ms, faster than 100.00% Memory Usage: 37.1 MB, less than 60.25%  */
public class ScoreOfParentheses {
    public int scoreOfParentheses(String S) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int prev = stack.pop();
                int prevOfPrev = stack.pop();
                stack.push(prevOfPrev + (prev == 0 ? 1 : prev * 2));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {

        /*
         * Input: "(()(()))" Output: 6
         */
        String S1 = "()";
        String S2 = "(())";
        String S3 = "()()";
        String S4 = "(()(()))";
        System.out.println(new ScoreOfParentheses().scoreOfParentheses(S4));
    }
}
