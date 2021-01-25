package leetcode.arrays;

/* https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/ */
/* Runtime: 1 ms, faster than 100.00% */
public class CheckIfAllOnesAreAtLeastLengthKPlacesAway {
    public boolean kLengthApart(int[] nums, int k) {

        int left = -1;
        int right = 0;

        while (right < nums.length) {
            if (nums[right] == 1) {
                if (left >= 0 && right - left - 1 < k) {
                    return false;
                }
                left = right;
            }

            right++;
        }

        return true;
    }
}
