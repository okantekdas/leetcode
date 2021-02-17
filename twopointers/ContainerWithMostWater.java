package leetcode.twopointers;

/* https://leetcode.com/problems/container-with-most-water/ */
/* Runtime: 2 ms, faster than 96.04% Memory Usage: 40.2 MB, less than 94.32%*/
public class ContainerWithMostWater {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[] { 4, 3, 2, 1, 4 }));
    }
}
