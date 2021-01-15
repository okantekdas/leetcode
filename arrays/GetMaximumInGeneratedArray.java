package leetcode.arrays;

/* https://leetcode.com/problems/get-maximum-in-generated-array/ */
/* Runtime: 0 ms, faster than 100.00% */
public class GetMaximumInGeneratedArray {
    public int getMaximumGenerated(int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        int max = 1;
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i / 2];
            } else {
                arr[i] = arr[i / 2] + arr[i / 2 + 1];
            }
            max = Math.max(max, arr[i]);

        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new GetMaximumInGeneratedArray().getMaximumGenerated(97));
    }

}
