package leetcode.other;

import java.util.Stack;

/* https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses */
public class ReverseSubstringsBetweenEachPairOfParentheses {

    /* Runtime: 10 ms, faster than 6.94% Memory Usage: 39.8 MB, less than 100.00% */
    public String reverseParentheses(String s) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int leftIndex = stack.pop();

                String left = s.substring(0, leftIndex);
                String right = s.substring(i + 1, s.length());

                String reversedStr = reverse(s.substring(leftIndex + 1, i));

                s = left + reversedStr + right;
                if (stack.isEmpty()) {
                    i = reversedStr.length();
                } else {
                    i = stack.peek() + reversedStr.length();
                }
            }

        }

        return s;

    }

    public String reverse(String str) {

        String reversedStr = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversedStr += str.charAt(i);
        }

        return reversedStr;

    }

    public static void main(String[] args) {
        String s = "ta()usw((((a))))";
        // String s = "((eqk((h))))";
        // String s = "vdgzyj()";
        // String s = "mno";
        // String s = "abcd";
        // String s = "a(bcdefghijkl(mno)p)q";
        // String s = "(ed(et(oc))el)";
        // String s = "(abcd)";

        System.out.println(new ReverseSubstringsBetweenEachPairOfParentheses().reverseParentheses(s));
    }

}