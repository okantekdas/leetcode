package leetcode.other;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public class SubSolution {
        int smallest = 0;
        int total = 0;
    }

    public static void main(String[] args) {

        int[] heights = { 5, 4, 1, 2 };

        System.out.println("Result: " + new LargestRectangleInHistogram().largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {

        int max = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            if (stack.size() == 0) {
                stack.push(i);
            } else if (heights[stack.peek()] < heights[i]) {
                stack.push(i);
            } else if (heights[stack.peek()] == heights[i]) {
                stack.push(i);
            } else {

                while (stack.size() > 0 && heights[stack.peek()] > heights[i]) {
                    int poppedValue = stack.pop();
                    int localArea = heights[poppedValue] * (stack.empty() ? i : i - stack.peek() - 1);
                    if (localArea > max) {
                        max = localArea;
                    }

                }
                stack.push(i);

            }

        }

        for (int i = 0; i < stack.size(); i++) {
            int width = 0;
            if (i == 0) {
                width = heights.length;
            } else {
                width = heights.length - stack.get(i - 1) - 1;
            }
            int localArea = heights[stack.get(i)] * width;
            if (localArea > max) {
                max = localArea;
            }
        }

        return max;
    }

    public int largestRectangleAreaAlternate(int[] heights) {
        int biggest = 0;
        if (heights == null || heights.length == 0) {
            return biggest;
        }

        int length = heights.length;
        SubSolution[] subSolutions = new SubSolution[length];

        for (int i = 0; i < length; i++) {

            int current = heights[i];

            subSolutions[i] = new SubSolution();
            subSolutions[i].smallest = current;
            subSolutions[i].total = current;
            if (biggest < current) {
                biggest = current;
            }

            for (int j = 0; j < i; j++) {
                if (subSolutions[j].smallest > current) {
                    subSolutions[j].smallest = current;
                }
                subSolutions[j].total = (i - j + 1) * subSolutions[j].smallest;

                if (biggest < subSolutions[j].total) {
                    biggest = subSolutions[j].total;
                }
            }

        }

        return biggest;

    }

}