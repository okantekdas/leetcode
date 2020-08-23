package leetcode.other;

import java.util.Random;
import java.util.TreeMap;

/* https://leetcode.com/problems/random-point-in-non-overlapping-rectangles */
public class RandomPointInNonOverlappingRectangles {

    class Solution {

        TreeMap<Integer, int[]> areaToIndex = new TreeMap<>();
        int area = 0;
        Random r = new Random();

        public Solution(int[][] rects) {

            for (int[] rect : rects) {
                area += (rect[3] - rect[1] + 1) * (rect[2] - rect[0] + 1);
                areaToIndex.put(area, rect);
            }

        }

        public int[] pick() {
            int randomKey = r.nextInt(area);
            int[] randomRect = areaToIndex.get(areaToIndex.higherKey(randomKey));

            int x = randomRect[0] + r.nextInt(Math.abs(randomRect[2] - randomRect[0] + 1));
            int y = randomRect[1] + r.nextInt(Math.abs(randomRect[3] - randomRect[1] + 1));

            return new int[] { x, y };

        }
    }

}