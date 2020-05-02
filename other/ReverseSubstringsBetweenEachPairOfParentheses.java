package leetcode.other;

import java.util.Stack;

/* https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses */
public class ReverseSubstringsBetweenEachPairOfParentheses {

    public class Subsolution {
        int parCount = 0;
        String solution;

        public Subsolution(int parCount, String solution) {
            this.parCount = parCount;
            this.solution = solution;
        }

    }

    /* Runtime: 1 ms, faster than 97.01% Memory Usage: 38.9 MB, less than 100.00% */
    public String reverseParentheses(String s) {

        Subsolution subsolution = reverseInnerParentheses(s);

        return subsolution.solution;
    }

    public Subsolution reverseInnerParentheses(String s) {

        StringBuilder strBuilder = new StringBuilder();
        int parCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '(' && c != ')') {
                strBuilder.append(c);
            } else if (c == '(') {
                // recurse
                parCount++;
                Subsolution subsolution = reverseInnerParentheses(s.substring(i + 1));
                parCount += subsolution.parCount;
                strBuilder.append(reverse(subsolution.solution));
                i += subsolution.solution.length() + subsolution.parCount;
            } else if (c == ')') {
                return new Subsolution(parCount + 1, strBuilder.toString());
            }
        }

        return new Subsolution(parCount, strBuilder.toString());
    }

    /* Runtime: 2 ms, faster than 59.30%% Memory Usage: 39.8 MB, less than 100.00% */
    public String reverseParenthesesAltenrate(String s) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int leftIndex = stack.pop();

                String left = s.substring(0, leftIndex);
                String right = s.substring(i + 1, s.length());
                StringBuilder strBuilder = new StringBuilder();
                String reversedStr = reverse(s.substring(leftIndex + 1, i));
                strBuilder.append(left).append(reversedStr).append(right);
                s = strBuilder.toString();
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

        StringBuilder reversedStrBuilder = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            reversedStrBuilder.append(str.charAt(i));
        }

        return reversedStrBuilder.toString();

    }

    public static void main(String[] args) {
        // String s = "ta()usw((((a))))";
        // String s = "((eqk((h))))";
        // String s = "vdgzyj()";
        // String s = "mno";
        // String s = "abcd";
        // String s = "a(bcdefghijkl(mno)p)q";
        // String s = "(u(love)i)";
        String s = "(ed(et(oc))el)";
        // String s = "(abcd)";

        System.out.println(new ReverseSubstringsBetweenEachPairOfParentheses().reverseParentheses(s));
    }

}