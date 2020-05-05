package leetcode.tree;

/* https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/ */
public class MinimumCostTreeFromLeafValues {

    public int mctFromLeafValues(int[] arr) {

        calculatemctFromLeafValues(arr, 0, arr.length - 1);
        return solution;
    }

    int solution = 0;

    public int calculatemctFromLeafValues(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        if (left > right) {
            return 0;
        }

        int pivot = 0;
        int pivotIndex = 0;

        for (int i = left; i <= right; i++) {
            if (pivot < arr[i]) {
                pivot = arr[i];
                pivotIndex = i;
            }
        }

        int subsolution = pivot * (calculatemctFromLeafValues(arr, left, pivotIndex - 1)
                + calculatemctFromLeafValues(arr, pivotIndex + 1, right));
        solution += subsolution;

        return pivot;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 2, 4 };
        System.out.println(new MinimumCostTreeFromLeafValues().mctFromLeafValues(arr));
    }

}