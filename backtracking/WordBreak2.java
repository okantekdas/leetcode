package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* https://leetcode.com/problems/word-break-ii/ */
public class WordBreak2 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<StringBuilder> sol = calculateWordBreak(s, wordDict, new HashMap<>());
        List<String> solution = new ArrayList<>();
        if (sol != null) {
            for (int i = 0; i < sol.size(); i++) {
                solution.add(sol.get(i).toString());
            }
        }

        return solution;
    }

    public List<StringBuilder> calculateWordBreak(String s, List<String> wordDict,
            HashMap<String, List<StringBuilder>> strToSolution) {
        List<StringBuilder> solutions = null;
        if (s == null || s.isEmpty()) {
            return solutions = new ArrayList<>();
        }

        if (strToSolution.containsKey(s)) {
            return strToSolution.get(s);
        }

        for (String word : wordDict) {

            if (s.length() >= word.length()) {
                String subs = s.substring(0, word.length());
                if (subs.equals(word)) {
                    List<StringBuilder> subsolution = calculateWordBreak(s.substring(word.length(), s.length()),
                            wordDict, strToSolution);
                    if (subsolution != null) {
                        if (solutions == null) {
                            solutions = new ArrayList<>();
                        }
                        List<StringBuilder> cloneSubsolution = new ArrayList<>();
                        cartesianProduct(subsolution, subs, cloneSubsolution);
                        solutions.addAll(cloneSubsolution);
                    }
                }
            }

        }

        strToSolution.put(s, solutions);
        return solutions;
    }

    private void cartesianProduct(List<StringBuilder> subsolution, String subs, List<StringBuilder> solutions) {
        if (subsolution.isEmpty()) {
            solutions.add(new StringBuilder(subs));
        } else {
            for (int i = 0; i < subsolution.size(); i++) {
                StringBuilder strBuilder = new StringBuilder();
                strBuilder.append(subs);
                strBuilder.append(" ");
                strBuilder.append(subsolution.get(i));
                solutions.add(i, strBuilder);
            }
        }

    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        // String s = "pineapplepenapple";
        // List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine",
        // "pineapple");
        List<String> solution = new WordBreak2().wordBreak(s, wordDict);
        System.out.println(Arrays.toString(solution.toArray()));
    }
}