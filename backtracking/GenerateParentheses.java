package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {

    ArrayList<String> solution = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        parenthesisCombination(n, 0, 0, "");
        return solution;

    }

    public void parenthesisCombination(int n, int leftCount, int rightCount, String str) {
        if (leftCount > n || rightCount > n || rightCount > leftCount) {
            return;
        }

        if (leftCount == n && rightCount == n) {
            solution.add(str);
        }

        parenthesisCombination(n, leftCount + 1, rightCount, str + "(");
        parenthesisCombination(n, leftCount, rightCount + 1, str + ")");

    }

    public static void main(String[] args) {
        List<String> solution = new GenerateParentheses().generateParenthesis(4);
        String[] strArr = solution.toArray(new String[0]);
        Arrays.sort(strArr);
        System.out.println("Size: " + solution.size());
        System.out.println(Arrays.toString(strArr));

    }

}