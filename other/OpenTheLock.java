package leetcode.other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {

    public int openLock(String[] deadends, String target) {

        Set<String> visitedNodes = new HashSet<>(Arrays.asList(deadends));

        Queue<String> queue = new LinkedList<>();

        queue.add("0000");

        int step = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String currentState = queue.poll();

                if (!visitedNodes.contains(currentState)) {

                    if (currentState.equals(target)) {
                        return step;
                    }
                    addPossibilities(currentState, queue, visitedNodes);

                    visitedNodes.add(currentState);
                }

            }
            step++;
        }

        return -1;
    }

    public void addPossibilities(String currentState, Queue<String> queue, Set<String> visitedNodes) {

        char[] charArr = currentState.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];

            charArr[i] = c == '0' ? '9' : (char) (c - 1);
            String option = String.valueOf(charArr);
            if (!visitedNodes.contains(String.valueOf(option))) {
                queue.add(option);
            }

            charArr[i] = c == '9' ? '0' : (char) (c + 1);
            option = String.valueOf(charArr);
            if (!visitedNodes.contains(String.valueOf(option))) {
                queue.add(option);
            }

            charArr[i] = c;
        }

    }

    public static void main(String[] args) {

        String[] deadends = { "8888" };

        String target = "0009";
        // String[] deadends = { "0201", "0101", "0102", "1212", "2002" };

        // String target = "0202";

        System.out.println(new OpenTheLock().openLock(deadends, target));

    }

}