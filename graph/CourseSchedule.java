package leetcode.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* https://leetcode.com/problems/course-schedule */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, HashSet<Integer>> courseToPrereq = new HashMap<>();
        int[] memo = new int[numCourses];
        Arrays.fill(memo, -1);

        for (int[] pair : prerequisites) {
            HashSet<Integer> prereq = courseToPrereq.get(pair[0]);
            if (prereq == null) {
                prereq = new HashSet<>();
                courseToPrereq.put(pair[0], prereq);
            }
            prereq.add(pair[1]);

        }

        for (int i = 0; i < numCourses; i++) {
            if (isCircularDependent(i, new boolean[numCourses], courseToPrereq, memo)) {
                return false;
            }
        }

        return true;
    }

    public boolean isCircularDependent(int currentCourse, boolean[] visited,
            HashMap<Integer, HashSet<Integer>> courseToPrereq, int[] memo) {

        if (memo[currentCourse] != -1) {
            return memo[currentCourse] == 1 ? true : false;
        }
        if (visited[currentCourse]) {
            return true;
        }
        if (courseToPrereq.get(currentCourse) == null) {
            return false;
        }

        visited[currentCourse] = true;
        boolean isCircular = false;
        for (int course : courseToPrereq.get(currentCourse)) {
            isCircular |= isCircularDependent(course, visited, courseToPrereq, memo);
            if (isCircular) {
                break;
            }
        }

        memo[currentCourse] = isCircular == true ? 1 : 0;

        return isCircular;
    }

    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = { { 1, 0 }, { 0, 2 }, { 2, 1 } };

        System.out.println(new CourseSchedule().canFinish(numCourses, prerequisites));
    }

}