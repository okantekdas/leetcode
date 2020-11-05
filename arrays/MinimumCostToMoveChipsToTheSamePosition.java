package leetcode.arrays;

/* https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/ */
/* Runtime: 0 ms, faster than 100.00% */
public class MinimumCostToMoveChipsToTheSamePosition {
    public int minCostToMoveChips(int[] positions) {
        int oddCount = 0;
        int evenCount = 0;

        for (int position : positions) {
            if (position % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }

        }

        if (oddCount > evenCount) {
            return evenCount;
        }
        return oddCount;
    }

    public static void main(String[] args) {
        int[] position = { 1, 1, 1, 1, 1, 1, 1, 2, 2 };
        System.out.println(new MinimumCostToMoveChipsToTheSamePosition().minCostToMoveChips(position));
    }
}
