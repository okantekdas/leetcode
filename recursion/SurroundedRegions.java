package leetcode.recursion;

/* https://leetcode.com/problems/surrounded-regions/ */
public class SurroundedRegions {

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (!visited[y][x] && board[y][x] == 'O') {
                    boolean isSurvived = isSurrounded(board, y, x, visited);
                    if (!isSurvived) {
                        updateBoard(board, y, x);
                    }

                }
            }
        }

    }

    public void updateBoard(char[][] board, int y, int x) {

        board[y][x] = 'X';
        if (x + 1 < board[0].length && board[y][x + 1] == 'O') {
            updateBoard(board, y, x + 1);

        }
        if (x - 1 > -1 && board[y][x - 1] == 'O') {
            updateBoard(board, y, x - 1);

        }
        if (y + 1 < board.length && board[y + 1][x] == 'O') {
            updateBoard(board, y + 1, x);

        }
        if (y - 1 > -1 && board[y - 1][x] == 'O') {
            updateBoard(board, y - 1, x);

        }
    }

    public boolean isSurrounded(char[][] board, int y, int x, boolean visited[][]) {

        if ((y == 0 || y == board.length - 1 || x == 0 || x == board[0].length - 1) && board[y][x] == 'O') {
            return true;
        }

        visited[y][x] = true;
        boolean isSurvived = false;
        if (x + 1 < board[0].length && board[y][x + 1] == 'O' && !visited[y][x + 1]) {
            isSurvived |= isSurrounded(board, y, x + 1, visited);

        }
        if (x - 1 > -1 && board[y][x - 1] == 'O' && !visited[y][x - 1]) {
            isSurvived |= isSurrounded(board, y, x - 1, visited);

        }
        if (y + 1 < board.length && board[y + 1][x] == 'O' && !visited[y + 1][x]) {
            isSurvived |= isSurrounded(board, y + 1, x, visited);

        }
        if (y - 1 > -1 && board[y - 1][x] == 'O' && !visited[y - 1][x]) {
            isSurvived |= isSurrounded(board, y - 1, x, visited);

        }

        return isSurvived;

    }

    public static void main(String[] args) {

        // char[][] board = { { 'O', 'O' }, { 'O', 'O' } };
        char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'O', 'O', 'O' },
                { 'X', 'X', 'X', 'O' } };
        new SurroundedRegions().solve(board);

        int a = 5;
    }

}