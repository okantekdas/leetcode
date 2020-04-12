package leetcode.other;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return 1;
                } else if (o1 == o2) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        for (int stone : stones) {
            queue.add(stone);
        }

        while (queue.size() > 1) {

            int biggest = queue.poll();
            int secondBiggest = queue.poll();

            if (biggest >= secondBiggest) {
                int difference = biggest - secondBiggest;
                queue.add(difference);
            }
        }

        return queue.peek();

    }

    public static void main(String[] args) {
        int[] stones = { 2, 7, 4, 1, 8, 1 };
        System.out.println(new LastStoneWeight().lastStoneWeight(stones));
    }

}
