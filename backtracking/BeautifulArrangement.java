package leetcode.backtracking;

/* https://leetcode.com/problems/beautiful-arrangement/ */
/* Runtime: 62 ms, faster than 76.36% Memory Usage: 35.8 MB, less than 60.52% */
public class BeautifulArrangement {
    int count = 0;

    public int countArrangement(int n) {

        boolean[] visited = new boolean[n + 1];
        countArrangementHelper(n, 1, visited);
        return count;
    }

    public void countArrangementHelper(int n, int position, boolean[] visited) {
        if (position > n) {
            count++;
            return;
        }

        for (int i = n; i > 0; i--) {
            if (!visited[i] && (i % position == 0 || position % i == 0)) {
                visited[i] = true;
                countArrangementHelper(n, position + 1, visited);
                visited[i] = false;
            }
        }
    }

}
