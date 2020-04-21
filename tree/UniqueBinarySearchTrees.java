package leetcode.tree;

import java.util.HashMap;

/* https://leetcode.com/problems/unique-binary-search-trees/ */
public class UniqueBinarySearchTrees {

    HashMap<Integer, Integer> valToVariation = new HashMap<>();

    public int numTrees(int n) {

        int[] arr = new int[n];

        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        return calculateVariations(arr, 0, n - 1);
    }

    public int calculateVariations(int[] arr, int left, int right) {
        if (left >= right) {
            return 1;
        }
        /*
         * if (left == right) { return 1; }
         */

        if (valToVariation.containsKey(right - left)) {
            return valToVariation.get(right - left);
        }

        int variationsForIndex = 0;
        for (int i = left; i <= right; i++) {
            int leftSolution = calculateVariations(arr, left, i - 1);
            int rightSolution = calculateVariations(arr, i + 1, right);

            variationsForIndex += leftSolution * rightSolution;
            valToVariation.put(right - left, variationsForIndex);

        }

        return variationsForIndex;

    }

    public static void main(String[] args) {

        System.out.println(new UniqueBinarySearchTrees().numTrees(4));
    }

}