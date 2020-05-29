package leetcode.other;

import java.util.Arrays;
import java.util.Stack;

/* https://leetcode.com/problems/daily-temperatures */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {

        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < T.length; i++) {
            if (stack.isEmpty()) {
                stack.add(i);
            } else {
                int lastIndex = stack.peek();
                if (T[i] > T[lastIndex]) {
                    int currentIndex = stack.peek();
                    while (T[currentIndex] < T[i]) {
                        stack.pop();
                        result[currentIndex] = i - currentIndex;
                        if (stack.isEmpty()) {
                            break;
                        }
                        currentIndex = stack.peek();
                    }
                    stack.push(i);
                } else {
                    stack.push(i);
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[] T = { 73, 74, 75, 71, 69, 72, 76, 73 };
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(T)));
    }

}