package leetcode.arrays;

/* https://leetcode.com/problems/kth-missing-positive-number/ */
/* Runtime: 0 ms, faster than 100.00% */
public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {

        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                int diff = arr[i] - arr[i - 1] - 1;
                if (diff > 0) {
                    if (diff < k) {
                        k -= diff;
                    } else if (diff > k) {
                        return arr[i - 1] + k;
                    } else {
                        return arr[i - 1] + k;
                    }

                }
            } else if (arr[i] > 1) {
                if (arr[i] > k) {
                    return k;
                } else {
                    k -= arr[i] - 1;
                }
            }
        }

        return arr[arr.length - 1] + k;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3 };

        System.out.println(new KthMissingPositiveNumber().findKthPositive(arr, 1));
    }

}
