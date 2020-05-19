package leetcode.other;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Stack;

/* https://leetcode.com/problems/online-stock-span */
public class OnlineStockSpan {

    class StockSpanner {

        Stack<Integer> mainStack = new Stack<>();
        ArrayList<Integer> prices = new ArrayList<>();
        int index = 0;

        public StockSpanner() {

        }

        public int next(int price) {
            int solution = 1;
            while (!mainStack.isEmpty() && prices.get(mainStack.peek()) <= price) {
                mainStack.pop();
            }
            if (mainStack.isEmpty()) {
                solution = index + 1;
            } else {
                solution = index - mainStack.peek();
            }

            mainStack.push(index++);
            prices.add(price);

            return solution;
        }
    }

    static OnlineStockSpan oss = new OnlineStockSpan();

    public static void main(String[] args)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // String[] commands = { "StockSpanner", "next", "next", "next", "next", "next",
        // "next", "next" };

        // int[][] arguments = { {}, { 100 }, { 80 }, { 60 }, { 70 }, { 60 }, { 75 }, {
        // 85 } };
        String[] commands = { "StockSpanner", "next", "next", "next", "next", "next", "next", "next", "next", "next",
                "next" };

        int[][] arguments = { {}, { 28 }, { 14 }, { 28 }, { 35 }, { 46 }, { 53 }, { 66 }, { 80 }, { 87 }, { 88 } };

        StockSpanner stockSpanner = oss.new StockSpanner();

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            int[] argumentArr = arguments[i];
            for (Method method : stockSpanner.getClass().getDeclaredMethods()) {
                if (method.getName().equals(command)) {
                    if (method.getName().equals("next")) {
                        System.out.println(method.invoke(stockSpanner, argumentArr[0]));
                    }
                }
            }
        }
    }

}