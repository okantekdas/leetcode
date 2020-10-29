package leetcode.arrays;

/* https://leetcode.com/problems/maximize-distance-to-closest-person */
/* Runtime: 1 ms, faster than 100.00% */
public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int maxDistance = 0;
        int left = 0;
        int right = 1;
        int solution = 1;
        while (left < seats.length && right < seats.length) {
            if (seats[left] == 1) {
                left++;
            } else {
                if (seats[right] == 0) {
                    right++;
                } else {

                    if (left == 0) {
                        solution = Math.max(solution, right - left);
                    }
                    maxDistance = Math.max(maxDistance, right - left);
                    left = right;
                    right++;
                }
            }
        }
        solution = Math.max(solution, right - left);
        solution = Math.max(solution, (maxDistance - 1) / 2 + 1);

        return solution;
    }

    public static void main(String[] args) {
        int[] seats = { 0, 1, 0 };
        System.out.println(new MaximizeDistanceToClosestPerson().maxDistToClosest(seats));
    }
}
