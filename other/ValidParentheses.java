package leetcode.other;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> parStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                parStack.add(currentChar);
            } else {
                if (parStack.isEmpty()) {
                    return false;
                }
                char lastLeftChar = parStack.peek();
                if ((lastLeftChar == '(' && currentChar != ')') || (lastLeftChar == '{' && currentChar != '}')
                        || (lastLeftChar == '[' && currentChar != ']')) {
                    return false;
                }
                parStack.pop();
            }
        }

        return parStack.isEmpty() ? true : false;

    }

    public static void main(String[] args) {

        System.out.println(new ValidParentheses().isValid("{[]}"));

    }

}