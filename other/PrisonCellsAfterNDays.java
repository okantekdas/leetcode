package leetcode.other;

import java.util.Arrays;
import java.util.HashMap;

public class PrisonCellsAfterNDays {
    int loop = 0;
    HashMap<Integer, int[]> dayToPrison = new HashMap<>();

    public int[] prisonAfterNDays(int[] cells, int N) {

        dayToPrison.put(0, cells);
        int[] futureCells = new int[cells.length];
        for (int i = 1; i <= N; i++) {
            futureCells = calculateNextDay(i);
            if (loop > 0) {
                futureCells = dayToPrison.get(N % loop == 0 ? loop : N % loop);
                break;
            }
        }

        return futureCells;

    }

    private int[] calculateNextDay(int day) {

        int[] prevCells = dayToPrison.get(day - 1);
        int[] cells = new int[prevCells.length];

        for (int j = 1; j < prevCells.length - 1; j++) {
            if ((prevCells[j - 1] == 0 && prevCells[j + 1] == 0) || (prevCells[j - 1] == 1 && prevCells[j + 1] == 1)) {
                cells[j] = 1;
            } else {
                cells[j] = 0;
            }
        }
        for (int key : dayToPrison.keySet()) {
            boolean isSame = true;
            int[] xCells = dayToPrison.get(key);
            for (int d = 0; d < xCells.length; d++) {
                if (xCells[d] != cells[d]) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                loop = day - key;
                break;
            }
        }
        dayToPrison.put(day, cells);
        return cells;
    }

    public static void main(String[] args) {

        int[] cells = { 1, 1, 0, 1, 1, 0, 1, 1 };
        int N = 6;

        // int[] cells = { 1, 0, 0, 1, 0, 0, 1, 0 };
        // int N = 1000000000;

        System.out.println(Arrays.toString(new PrisonCellsAfterNDays().prisonAfterNDays(cells, N)));
    }

}