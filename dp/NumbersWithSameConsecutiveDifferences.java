package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {

    List<Integer> solutions = new ArrayList<>();

    public int[] numsSameConsecDiff(int N, int K) {

        calculateNumsSameConsecDiff(N, K, 0, "");
        int[] sol = new int[solutions.size()];
        int index = 0;
        for (int s : solutions) {
            sol[index++] = s;
        }
        return sol;
    }

    public void calculateNumsSameConsecDiff(int length, int diff, int prev, String num) {
        if (length == 0) {
            solutions.add(Integer.valueOf(num));
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (num.isEmpty() && length > 0 && i == 0) {
                continue;
            } else {
                if (!num.isEmpty()) {
                    if (Math.abs(i - prev) == diff) {
                        calculateNumsSameConsecDiff(length - 1, diff, i, num + String.valueOf(i));
                    }
                } else {
                    calculateNumsSameConsecDiff(length - 1, diff, i, num + String.valueOf(i));
                }
            }

        }

    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new NumbersWithSameConsecutiveDifferences().numsSameConsecDiff(9, 2)));

    }
}