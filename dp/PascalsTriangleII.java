package leetcode.dp;

import java.util.Arrays;
import java.util.List;

public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {

        Integer[] solution = new Integer[1];
        solution[0] = 1;

        for (int i = 1; i <= rowIndex; i++) {
            Integer[] newSolution = new Integer[i + 1];
            newSolution[0] = 1;
            newSolution[i] = 1;
            for (int j = 1; j < i; j++) {
                newSolution[j] = solution[j - 1] + solution[j];
            }
            solution = newSolution;
        }
        return Arrays.asList(solution);
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangleII().getRow(1));
    }

}