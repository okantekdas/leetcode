package leetcode.greedy;

import java.util.Arrays;

/* https://leetcode.com/problems/task-scheduler/ */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {

        int[] taskCount = new int[26];

        for (char task : tasks) {
            taskCount[task - 65]++;
        }

        Arrays.sort(taskCount);

        int pair = 1;
        int repetition = taskCount[25];
        for (int i = 24; i >= 0; i--) {
            if (taskCount[i] == repetition) {
                pair++;
            } else {
                break;
            }
        }

        int solution = pair * repetition + (repetition - 1) * (n - (pair - 1));
        return Math.max(tasks.length, solution);

    }

    public static void main(String[] args) {
        char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
        System.out.println(new TaskScheduler().leastInterval(tasks, 2));
    }

}