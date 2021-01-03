package leetcode.backtracking;

/* https://leetcode.com/problems/beautiful-arrangement/ */
/* Runtime: 65 ms, faster than 69.57% Memory Usage: 35.8 MB, less than 60.52%  */
public class BeautifulArrangement {
    public int countArrangement(int n) {

        boolean[] visited = new boolean[n + 1];
        int count = 0;
        countArrangementHelper(n, 1, visited, count);
        return count;
    }

    public void countArrangementHelper(int n, int position, boolean[] visited, int count) {

        if (position > n) {
            count++;
            return;
        }

        for (int i = 1; i < n; i++) {
            if (!visited[i] && (i % position == 0 || position % i == 0)) {
                visited[i] = true;
                countArrangementHelper(n, position + 1, visited, count);
                visited[i] = false;
            }
        }
    }

}
