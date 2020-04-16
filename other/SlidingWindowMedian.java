package leetcode.other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/* https://leetcode.com/problems/sliding-window-median/ */
public class SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {

        PriorityQueue<Long> min = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Long> max = new PriorityQueue<>();

        double[] solution = new double[nums.length - k + 1];

        int low = 0;
        int high = -1;
        boolean isEven = k % 2 == 0 ? true : false;
        int minSize = isEven == true ? k / 2 : k / 2 + 1;
        int maxSize = k / 2;
        while (low <= nums.length - k) {
            if (high - low + 1 == k) {

                double median;
                if (isEven) {
                    median = (double) (min.peek() + max.peek()) / 2;
                } else {
                    median = min.peek();
                }
                solution[low] = median;
                long valToRemove = nums[low];
                if (min.contains(valToRemove)) {
                    min.remove(valToRemove);
                } else {
                    max.remove(valToRemove);
                }

                low++;
            }
            high++;
            if (high < nums.length) {
                long current = nums[high];
                if (min.isEmpty()) {
                    min.add((long) nums[high]);
                } else {
                    if (min.peek() > current) {
                        if (min.size() < minSize) {
                            min.add(current);
                        } else {
                            max.add(min.poll());
                            min.add(current);
                        }
                    } else {
                        if (max.size() < maxSize) {
                            max.add(current);
                        } else {
                            if (max.peek() < current) {
                                min.add(max.poll());
                                max.add(current);
                            } else {
                                min.add(current);
                            }

                        }
                    }
                }
            }
        }
        return solution;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        System.out.println(Arrays.toString(new SlidingWindowMedian().medianSlidingWindow(nums, k)));
    }

}