package leetcode.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/jump-game-iv/ */
/* Runtime: 37 ms, faster than 98.47% */
public class JumpGame4 {
    public int minJumps(int[] arr) {

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> path = graph.getOrDefault(arr[i], new ArrayList<>());
            graph.putIfAbsent(arr[i], path);
            path.add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        int target = arr.length - 1;
        int step = 0;
        boolean[] visited = new boolean[arr.length];
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int index = queue.poll();

                ArrayList<Integer> paths = graph.get(arr[index]);
                visited[index] = true;

                if (index == target) {
                    return step;
                }

                for (int j = paths.size() - 1; j >= 0; j--) {
                    if (paths.get(j) == target) {
                        return step + 1;
                    }
                    if (!visited[paths.get(j)]) {
                        queue.add(paths.get(j));
                    }
                }

                int prevIndex = index - 1;
                int nextIndex = index + 1;
                if (prevIndex >= 0) {
                    if (prevIndex == target) {
                        return step + 1;
                    }
                    if (!visited[prevIndex]) {
                        queue.add(prevIndex);
                    }
                }
                if (nextIndex < arr.length) {
                    if (nextIndex == target) {
                        return step + 1;
                    }
                    if (!visited[nextIndex]) {
                        queue.add(nextIndex);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
                7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 11 };

        System.out.println(new JumpGame4().minJumps(arr));
    }
}
