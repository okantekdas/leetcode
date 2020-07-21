package leetcode.backtracking;

/* https://leetcode.com/problems/word-search/ */
public class WordSearch {

    public boolean exist(char[][] board, String word) {

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] == word.charAt(0)) {
                    boolean solution = exist(board, word, y, x, 0, new boolean[board.length][board[0].length]);
                    if (solution) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean exist(char[][] board, String word, int y, int x, int index, boolean visited[][]) {

        if (index == word.length()) {
            return true;
        }
        if (y >= board.length || y < 0 || x >= board[0].length || x < 0 || board[y][x] != word.charAt(index)
                || visited[y][x]) {
            return false;
        }

        boolean solution = false;
        visited[y][x] = true;
        solution |= exist(board, word, y, x + 1, index + 1, visited) || exist(board, word, y, x - 1, index + 1, visited)
                || exist(board, word, y + 1, x, index + 1, visited) || exist(board, word, y - 1, x, index + 1, visited);

        if (!solution) {
            visited[y][x] = false;
        }

        return solution;
    }

    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCESEEEFS";

        System.out.println(new WordSearch().exist(board, word));
    }
}