package leetcode.arrays;

/* https://leetcode.com/problems/valid-mountain-array/ */
/* Runtime: 1 ms, faster than 100.00% Memory Usage: 40.2 MB, less than 44.46% */
public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {

        if (arr == null || arr.length < 3) {
            return false;
        }

        boolean isTopReached = false;
        int rightSlope = 0;
        for (int i = 1; i < arr.length; i++) {

            if (!isTopReached && arr[i] > arr[i - 1]) {
                // right slope

                rightSlope++;
            } else if (rightSlope > 0 && (arr[i] < arr[i - 1])) {
                // left slope
                if (arr[i - 1] > arr[i]) {
                    isTopReached = true;
                }
            } else {
                return false;
            }
        }
        return isTopReached == true ? true : false;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 3, 2, 1 };
        System.out.println(new ValidMountainArray().validMountainArray(arr));
    }
}
