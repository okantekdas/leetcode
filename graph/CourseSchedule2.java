package leetcode.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* https://leetcode.com/problems/course-schedule-ii */
public class CourseSchedule2 {

    int index = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        HashMap<Integer, HashSet<Integer>> courseToPrereq = new HashMap<>();

        for (int[] pair : prerequisites) {
            HashSet<Integer> prereq = courseToPrereq.get(pair[0]);
            if (prereq == null) {
                prereq = new HashSet<>();
                courseToPrereq.put(pair[0], prereq);
            }
            prereq.add(pair[1]);

        }

        int[] solution = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                boolean hasCycle = traverseGraph(i, visited, new boolean[numCourses], courseToPrereq, solution);
                if (hasCycle) {
                    solution = new int[0];
                    break;
                }
            }

        }

        return solution;
    }

    private boolean traverseGraph(int course, boolean[] visited, boolean[] explored,
            HashMap<Integer, HashSet<Integer>> courseToPrereq, int[] solution) {

        if (visited[course]) {
            return false;
        }
        if (explored[course]) {
            return true;
        }
        if (courseToPrereq.get(course) == null) {
            if (!visited[course]) {
                visited[course] = true;
                solution[index++] = course;
            }

            return false;
        }

        explored[course] = true;

        for (int prereq : courseToPrereq.get(course)) {
            boolean hasCycle = traverseGraph(prereq, visited, explored, courseToPrereq, solution);
            if (hasCycle) {
                return hasCycle;
            }
        }

        visited[course] = true;
        solution[index++] = course;

        return false;

    }

    public static void main(String[] args) {
        int numCourses = 2;
        // int[][] prereq = { { 1, 0 }, { 0, 3 }, { 0, 2 }, { 3, 2 }, { 2, 5 }, { 4, 5
        // }, { 5, 6 }, { 2, 4 } };
        // int[][] prereq = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
        int[][] prereq = { { 0, 1 }, { 1, 0 } };
        // int[][] prereq = { { 1, 0 } };
        // int[][] prereq = { { 1, 0 }, { 2, 1 } };

        int[] solution = new CourseSchedule2().findOrder(numCourses, prereq);
        System.out.println(Arrays.toString(solution));
    }

}