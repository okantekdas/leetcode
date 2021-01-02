package leetcode.arrays;

import java.util.HashMap;

/* https://leetcode.com/problems/check-array-formation-through-concatenation/ */
/* Runtime: 0 ms, faster than 100.00% Memory Usage: 38 MB, less than 92.23% */
public class CheckArrayFormationThroughConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {

        HashMap<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < pieces.length; i++) {

            numToIndex.put(pieces[i][0], i);
        }

        int arrIndex = 0;
        while (arrIndex < arr.length) {
            int number = arr[arrIndex++];
            if (!numToIndex.containsKey(number)) {
                return false;
            }

            int[] piece = pieces[numToIndex.get(number)];
            for (int i = 1; i < piece.length; i++) {
                number = arr[arrIndex++];
                if (piece[i] != number) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 15, 88 };
        int[][] pieces = { { 88 }, { 15 } };

        System.out.println(new CheckArrayFormationThroughConcatenation().canFormArray(arr, pieces));
    }
}
