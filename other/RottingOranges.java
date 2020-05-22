package leetcode.other;

import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/rotting-oranges/ */
public class RottingOranges {

    class Rotten {
        int x, y;

        public Rotten(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            Rotten other = (Rotten) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }

    }

    public int orangesRotting(int[][] grid) {

        int freshCount = 0;
        Queue<Rotten> rottenQueue = new LinkedList<>();
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 2) {
                    rottenQueue.add(new Rotten(x, y));
                } else if (grid[y][x] == 1) {
                    freshCount++;
                }
            }
        }

        int turn = 0;

        while (!rottenQueue.isEmpty()) {

            int queueSize = rottenQueue.size();

            boolean hasRotten = false;
            for (int i = 0; i < queueSize; i++) {

                Rotten rotten = rottenQueue.poll();

                if (rotten.y - 1 >= 0 && grid[rotten.y - 1][rotten.x] == 1) {
                    Rotten r = new Rotten(rotten.x, rotten.y - 1);
                    if (!rottenQueue.contains(r)) {
                        grid[rotten.y - 1][rotten.x] = 2;
                        rottenQueue.add(r);
                        freshCount--;
                        hasRotten = true;
                    }

                }
                if (rotten.y + 1 < grid.length && grid[rotten.y + 1][rotten.x] == 1) {
                    Rotten r = new Rotten(rotten.x, rotten.y + 1);
                    if (!rottenQueue.contains(r)) {
                        grid[rotten.y + 1][rotten.x] = 2;
                        rottenQueue.add(r);
                        freshCount--;
                        hasRotten = true;
                    }
                }
                if (rotten.x - 1 >= 0 && grid[rotten.y][rotten.x - 1] == 1) {
                    Rotten r = new Rotten(rotten.x - 1, rotten.y);
                    if (!rottenQueue.contains(r)) {
                        grid[rotten.y][rotten.x - 1] = 2;
                        rottenQueue.add(r);
                        freshCount--;
                        hasRotten = true;
                    }
                }
                if (rotten.x + 1 < grid[0].length && grid[rotten.y][rotten.x + 1] == 1) {
                    Rotten r = new Rotten(rotten.x + 1, rotten.y);
                    if (!rottenQueue.contains(r)) {
                        grid[rotten.y][rotten.x + 1] = 2;
                        rottenQueue.add(r);
                        freshCount--;
                        hasRotten = true;
                    }
                }

            }
            if (hasRotten) {
                turn++;
            }
        }

        return freshCount == 0 ? turn : -1;

    }

    public static void main(String[] args) {

        // int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        // int[][] grid = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
        int[][] grid = { { 0, 1 } };

        System.out.println(new RottingOranges().orangesRotting(grid));
    }

}