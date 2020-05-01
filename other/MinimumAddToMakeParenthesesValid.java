package leetcode.other;

import java.util.Stack;

/* https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/ */
public class MinimumAddToMakeParenthesesValid {

    public int minAddToMakeValid(String S) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < S.length(); i++) {

            if (S.charAt(i) == '(') {
                left++;
            } else if (left > 0) {
                left--;
            } else {
                right++;
            }

        }
        return left + right;
    }

    /* 1ms */
    public int minAddToMakeValidAlternate(String S) {

        Stack<Integer> stack = new Stack<>();

        int minAdd = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.add(i);
            } else {

                if (stack.isEmpty()) {
                    minAdd++;
                } else {
                    stack.pop();
                }

            }
        }
        minAdd += stack.size();

        return minAdd;
    }

    public static void main(String[] args) {

        String S = ")((";

        System.out.println(new MinimumAddToMakeParenthesesValid().minAddToMakeValid(S));
    }

}