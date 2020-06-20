package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    int[] factorials = new int[10];

    public String getPermutation(int n, int k) {

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        return getPermutationHelper(numbers, k, new StringBuilder()).toString();
    }

    public StringBuilder getPermutationHelper(List<Integer> numbers, int k, StringBuilder solution) {

        if (numbers.size() == 0) {
            return solution;
        }

        int length = numbers.size();
        for (int i = 0; i < numbers.size(); i++) {
            if (factorial(length - 1) < k) {
                k -= factorial(length - 1);
            } else {
                solution.append(numbers.get(i));
                numbers.remove(i);
                break;
            }

        }

        return getPermutationHelper(numbers, k, solution);
    }

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (factorials[n] != 0) {
            return factorials[n];
        }

        int solution = n * factorial(n - 1);
        factorials[n] = solution;
        return solution;

    }

    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(4, 9));
    }
}