package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/* https://leetcode.com/problems/find-median-from-data-stream/ */
public class MedianFinder {

    PriorityQueue<Integer> smallerQueue = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> biggerQueue = new PriorityQueue<>();

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {

        if (smallerQueue.size() == 0) {
            smallerQueue.add(num);
        } else {

            if (smallerQueue.size() == biggerQueue.size()) {

                if (smallerQueue.peek() > num) {
                    smallerQueue.add(num);
                } else {
                    biggerQueue.add(num);
                    smallerQueue.add(biggerQueue.poll());
                }
            } else if (smallerQueue.size() > biggerQueue.size()) {
                if (smallerQueue.peek() > num) {
                    smallerQueue.add(num);
                    biggerQueue.add(smallerQueue.poll());
                } else {
                    biggerQueue.add(num);
                }

            }
        }

    }

    public double findMedian() {

        double result = 0;
        if (smallerQueue.size() == biggerQueue.size()) {
            result += smallerQueue.peek();
            result += biggerQueue.peek();
            result /= 2;
        } else {
            result = smallerQueue.peek();
        }

        return result;

    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);

        double median = medianFinder.findMedian();
        System.out.println(median);

        medianFinder.addNum(2);

        median = medianFinder.findMedian();
        System.out.println(median);

        medianFinder.addNum(3);

        median = medianFinder.findMedian();
        System.out.println(median);

        medianFinder.addNum(4);

        median = medianFinder.findMedian();
        System.out.println(median);

        medianFinder.addNum(0);

        median = medianFinder.findMedian();
        System.out.println(median);

        medianFinder.addNum(-1);

        median = medianFinder.findMedian();
        System.out.println(median);

    }
}