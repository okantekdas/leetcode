package leetcode.other;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations {

    static String PUSH = "Push";
    static String POP = "Pop";

    public List<String> buildArray(int[] target, int n) {

        int targetIndex = 0;
        List<String> solution = new ArrayList<>();

        if (target == null || target.length == 0) {
            return solution;
        }

        for (int i = 1; i <= n && targetIndex < target.length; i++) {

            if (target[targetIndex] != i) {
                solution.add(PUSH);
                solution.add(POP);
            } else if (target[targetIndex] == i) {
                solution.add(PUSH);
                targetIndex++;
            }

        }

        return solution;

    }

}