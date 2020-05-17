package leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/* https://leetcode.com/problems/k-closest-points-to-origin */
public class KClosestPointsToOrigin {

    class Point {
        int x;
        int y;
        int distance;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

    }

    public int[][] kClosest(int[][] points, int K) {

        PriorityQueue<Point> pointMaxHeap = new PriorityQueue<>(new Comparator<Point>() {

            @Override
            public int compare(Point p1, Point p2) {
                if (p1.distance > p2.distance) {
                    return -1;
                } else if (p1.distance == p2.distance) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        for (int[] p : points) {
            int distance = p[0] * p[0] + p[1] * p[1];
            Point point = new Point(p[0], p[1], distance);

            if (pointMaxHeap.size() == K) {
                if (pointMaxHeap.peek().distance > distance) {
                    pointMaxHeap.poll();
                    pointMaxHeap.add(point);
                }
            } else {
                pointMaxHeap.add(point);
            }

        }

        int[][] solution = new int[K][];
        for (int i = 0; i < K; i++) {
            int[] pointArr = new int[2];
            Point point = pointMaxHeap.poll();
            pointArr[0] = point.x;
            pointArr[1] = point.y;
            solution[i] = pointArr;

        }

        return solution;

    }

    public static void main(String[] args) {

        int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int K = 2;

        int[][] solution = new KClosestPointsToOrigin().kClosest(points, K);

        System.out.println(Arrays.deepToString(solution));

    }
}