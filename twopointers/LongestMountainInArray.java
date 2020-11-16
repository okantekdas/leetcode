package leetcode.twopointers;

/* https://leetcode.com/problems/longest-mountain-in-array/ */
/* Runtime: 2 ms, faster than 85.14% Memory Usage: 40 MB, less than 72.34%*/
public class LongestMountainInArray {
    public int longestMountain(int[] A) {

        int left = 0;
        int right = 0;
        int longest = 0;

        while (right < A.length) {
            if (left == right) {
                right++;
            } else {
                int leftPeak = 1;
                while (right < A.length && A[left] < A[right]) {
                    left++;
                    right++;
                    leftPeak++;
                }
                if (leftPeak > 1) {
                    int rightPeak = 0;
                    while (right < A.length && A[left] > A[right]) {
                        left++;
                        right++;
                        rightPeak++;
                    }
                    if (rightPeak > 0) {
                        longest = Math.max(longest, rightPeak + leftPeak);
                    }
                } else {
                    right++;
                    left++;
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] A = { 4, 5, 6, 6, 5, 4 };

        System.out.println(new LongestMountainInArray().longestMountain(A));
    }
}
