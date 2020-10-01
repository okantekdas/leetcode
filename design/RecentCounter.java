package leetcode.design;

import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/number-of-recent-calls */
/* Runtime: 19 ms, faster than 86.62% Memory Usage: 47.5 MB, less than 97.09% */
public class RecentCounter {

    Queue<Integer> queue = null;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);

        while (!queue.isEmpty()) {
            if (queue.peek() < t - 3000) {
                queue.poll();
            } else {
                break;
            }
        }

        return queue.size();
    }
}
