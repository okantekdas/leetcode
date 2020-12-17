package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/palindrome-partitioning/ */
/* Runtime: 8 ms, faster than 52.64% Memory Usage: 52.9 MB, less than 45.57% */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {

        List<List<String>> solution = new ArrayList<>();
        partitionHelper(s, 0, solution, new ArrayList<>());
        return solution;
    }

    public void partitionHelper(String s, int start, List<List<String>> solution, List<String> subSolution) {

        if (start >= s.length()) {
            solution.add(new ArrayList<>(subSolution));
        }

        for (int i = start; i < s.length(); i++) {

            if (isPalindrome(s, start, i)) {
                subSolution.add(s.substring(start, i + 1));
                partitionHelper(s, i + 1, solution, subSolution);
                subSolution.remove(subSolution.size() - 1);
            }

        }

    }

    public boolean isPalindrome(String s, int start, int end) {

        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
