package leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PancakeSorting {
    HashMap<Integer, Integer> numToIndex = new HashMap<>();

    public List<Integer> pancakeSort(int[] A) {

        for (int i = 0; i < A.length; i++) {
            numToIndex.put(A[i], i);
        }

        List<Integer> solution = new ArrayList<>();
        for (int num = A.length; num > 0; num--) {

            int index = numToIndex.get(num);

            if (index == num - 1) {
                continue;
            }

            if (num == 2) {
                flip(1, A);
                solution.add(1);
                break;
            }

            flip(index, A);
            solution.add(index);
            flip(num - 1, A);
            solution.add(num - 1);
        }

        System.out.println(Arrays.toString(A));

        return solution;
    }

    private void flip(int index, int[] A) {

        int right = index;
        int left = 0;
        while (left < right) {
            int temp = A[left];
            A[left++] = A[right];
            A[right--] = temp;

            numToIndex.put(A[left - 1], left - 1);
            numToIndex.put(A[right + 1], right + 1);
        }

    }

    public static void main(String[] args) {
        int[] A = { 3, 2, 4, 1 };
        System.out.println(Arrays.toString(new PancakeSorting().pancakeSort(A).toArray()));
    }

}