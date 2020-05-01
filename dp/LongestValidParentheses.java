package leetcode.dp;

import java.util.Stack;

/* https://leetcode.com/problems/longest-valid-parentheses/ */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ')') {

                if (stack.size() > 0) {
                    stack.pop();

                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        max = Math.max(max, i - stack.peek());

                    }

                }

            } else {
                stack.push(i);
            }
        }

        return max;
    }

    public static void main(String[] args) {

        String s = "()(())";

        System.out.println(new LongestValidParentheses().longestValidParentheses(s));

    }

}