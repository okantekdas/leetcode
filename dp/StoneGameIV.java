package leetcode.dp;

/* https://leetcode.com/problems/stone-game-iv/ */
/* Runtime: 40 ms, faster than 47.22% */
public class StoneGameIV {
    /* 0 = unvisited / 1 = true / -1 = false */
    int[] cache;

    public boolean winnerSquareGame(int n) {

        cache = new int[n + 1];
        return winnerSquareGameHelper(n);
    }

    public boolean winnerSquareGameHelper(int n) {

        if (n == 0) {
            return false;
        }
        if (cache[n] != 0) {
            return cache[n] == 1 ? true : false;
        }

        int sqrt = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) {
            if (!winnerSquareGameHelper(n - i * i)) {
                cache[n] = 1;
                return true;
            }
        }
        cache[n] = -1;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new StoneGameIV().winnerSquareGame(1907));
    }
}
