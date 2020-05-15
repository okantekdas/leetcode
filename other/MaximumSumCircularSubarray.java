package leetcode.other;

/* https://leetcode.com/problems/maximum-sum-circular-subarray */
public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] A) {

        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int currentMaxSum = 0;
        int currentMinSum = 0;
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            total += A[i];
            currentMaxSum = Math.max(currentMaxSum + A[i], A[i]);
            currentMinSum = Math.min(0, Math.min(currentMinSum + A[i], A[i]));
            maxSum = Math.max(maxSum, currentMaxSum);
            minSum = Math.min(minSum, currentMinSum);
        }

        return maxSum < 0 ? maxSum : Math.max(maxSum, total - minSum);

    }

    public static void main(String[] args) {

        int[] A = { 5, -3, 5 };

        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(A));

    }

}