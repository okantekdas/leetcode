package leetcode.design;

import java.util.HashMap;
import java.util.Stack;

/* https://leetcode.com/problems/maximum-frequency-stack/ */
/* Runtime: 27 ms, faster than 64.31% Memory Usage: 48.4 MB, less than 60.75%  */
public class MaximumFrequencyStack {

    class FreqStack {

        HashMap<Integer, Integer> numToFrequency;
        HashMap<Integer, Stack<Integer>> frequencyToStack;

        int mostFrequent;

        public FreqStack() {
            numToFrequency = new HashMap<>();
            frequencyToStack = new HashMap<>();
        }

        public void push(int x) {
            numToFrequency.putIfAbsent(x, 0);
            int frequency = numToFrequency.get(x) + 1;
            mostFrequent = Math.max(mostFrequent, frequency);
            numToFrequency.put(x, frequency);

            frequencyToStack.putIfAbsent(frequency, new Stack<>());
            Stack<Integer> currentStack = frequencyToStack.get(frequency);
            currentStack.push(x);
        }

        public int pop() {
            Stack<Integer> stack = frequencyToStack.get(mostFrequent);

            int number = stack.pop();
            numToFrequency.put(number, mostFrequent - 1);
            if (!stack.isEmpty()) {
                mostFrequent--;
            }

            return number;
        }
    }

}
