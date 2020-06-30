package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* https://leetcode.com/problems/word-search-ii/ */
public class WordSearch2 {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = new TrieNode();
        constructTrie(root, words);
        List<String> solution = new ArrayList<>();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                findWord(board, y, x, root, solution, new boolean[board.length][board[0].length]);
            }
        }

        return solution;
    }

    private void findWord(char[][] board, int y, int x, TrieNode node, List<String> solution, boolean[][] visited) {
        if (y < 0 || x < 0 || y >= board.length || x >= board[0].length || visited[y][x]) {
            return;
        }

        if (node.children[board[y][x] - 'a'] == null) {
            return;
        }

        node = node.children[board[y][x] - 'a'];
        if (node.isWord && !solution.contains(node.word)) {
            solution.add(node.word);
        }

        visited[y][x] = true;
        findWord(board, y, x + 1, node, solution, visited);
        findWord(board, y, x - 1, node, solution, visited);
        findWord(board, y + 1, x, node, solution, visited);
        findWord(board, y - 1, x, node, solution, visited);

        visited[y][x] = false;

    }

    private void constructTrie(TrieNode root, String[] words) {

        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
            node.word = word;
        }
    }

    public static void main(String[] args) {
        // char[][] board = { { 'a', 'a' } };
        // String[] words = { "aaa" };
        char[][] board = { { 'a', 'b', 'c' }, { 'a', 'e', 'd' }, { 'a', 'f', 'g' } };
        String[] words = { "abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade" };
        // char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i',
        // 'h', 'k', 'r' },
        // { 'i', 'f', 'l', 'v' } };
        // String[] words = { "oath", "pea", "eat", "rain" };
        List<String> solution = new WordSearch2().findWords(board, words);

        System.out.println(Arrays.deepToString(solution.toArray()));
    }

}