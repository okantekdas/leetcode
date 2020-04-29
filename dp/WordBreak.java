package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        return calculateWordBreak(s, wordDict, new HashMap<>());
    }

    public boolean calculateWordBreak(String s, List<String> wordDict, HashMap<String, Boolean> found) {
        if (s.isEmpty()) {
            return true;
        }
        if (found.containsKey(s)) {
            return found.get(s);
        }

        boolean subsolution = false;
        for (String word : wordDict) {

            if (s.length() >= word.length()) {

                String substring = s.substring(0, word.length());

                if (substring.equals(word)) {
                    subsolution = true;
                    subsolution &= calculateWordBreak(s.substring(word.length(), s.length()), wordDict, found);

                    if (subsolution == true) {
                        break;
                    }

                }

            }

        }

        found.put(s, subsolution);

        return subsolution;
    }

    public static void main(String[] args) {

        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";

        List<String> wordDict = new ArrayList<>(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa",
                "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));

        System.out.println(new WordBreak().wordBreak(s, wordDict));
    }

}