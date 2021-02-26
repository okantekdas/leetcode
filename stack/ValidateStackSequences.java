package leetcode.stack;

import java.util.Stack;

/* https://leetcode.com/problems/validate-stack-sequences/ */
/* Runtime: 1 ms, faster than 95.06% */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 || pushed.length == 1) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();

        int pushIndex = 0;
        int popIndex = 0;

        stack.push(pushed[pushIndex++]);

        while (pushIndex <= pushed.length && popIndex <= popped.length) {

            if (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            } else if (pushIndex < pushed.length) {
                stack.push(pushed[pushIndex++]);

            } else {

                if (stack.isEmpty()) {
                    break;
                } else {
                    return false;
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushed = { 1, 2, 3, 4, 5 };
        int[] popped = { 4, 5, 3, 2, 1 };

        System.out.println(new ValidateStackSequences().validateStackSequences(pushed, popped));
    }
}
