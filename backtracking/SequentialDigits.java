package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> solution = new ArrayList<>();
        int lowLength = (int) Math.log10(low);
        int highLength = (int) Math.log10(high);

        for (int i = lowLength + 1; i <= highLength + 1; i++) {
            for (int j = 1; j <= 10 - i; j++) {
                int generatedNumber = generateSequentialNumber(j, i);
                if ((i == lowLength + 1 && generatedNumber < low) || (i == highLength + 1 && generatedNumber > high)) {
                    continue;
                }
                solution.add(generatedNumber);

            }
        }
        return solution;
    }

    public int generateSequentialNumber(int firstDigit, int length) {

        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            strBuilder.append(firstDigit++);
        }
        return Integer.valueOf(strBuilder.toString());
    }

    public static void main(String[] args) {
        System.out.println(new SequentialDigits().sequentialDigits(100, 23000));
    }
}
