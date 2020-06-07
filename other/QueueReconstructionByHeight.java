package leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/* https://leetcode.com/problems/queue-reconstruction-by-height/ */
public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });

        ArrayList<int[]> solution = new ArrayList<>();

        for (int[] person : people) {
            solution.add(person[1], person);
        }

        return solution.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };

        int[][] solution = new QueueReconstructionByHeight().reconstructQueue(people);

        System.out.println(Arrays.deepToString(solution));
    }

}