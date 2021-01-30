package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/* https://leetcode.com/problems/minimize-deviation-in-array/submissions/ */
/* Runtime: 100 ms, faster than 52.31%  */
public class MinimizeDeviationInArray {
    public int minimumDeviation(int[] nums) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 == 1) {
                num *= 2;
            }
            maxHeap.add(num);

            min = Math.min(min, num);

        }
        int solution = Integer.MAX_VALUE;
        while (true) {

            int max = maxHeap.poll();

            int diff = max - min;
            solution = Math.min(solution, diff);
            if (max % 2 == 1) {
                break;
            }
            int val = max / 2;
            min = Math.min(min, val);
            maxHeap.add(val);

        }

        return solution;

    }

    public static void main(String[] args) {

        int[] nums = { 4, 1, 5, 20, 3 };

        System.out.println(new MinimizeDeviationInArray().minimumDeviation(nums));
    }
}
