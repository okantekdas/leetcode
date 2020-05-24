package leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* https://leetcode.com/problems/word-ladder/ */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Set<String>> wordToNeighbor = new HashMap<>();
        wordList.add(0, beginWord);

        for (int i = 0; i < wordList.size(); i++) {
            String first = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                String second = wordList.get(j);
                if (!first.equals(second)) {
                    if (hasOneChange(first, second)) {
                        if (wordToNeighbor.containsKey(first)) {
                            wordToNeighbor.get(first).add(second);
                        } else {
                            Set<String> list = new HashSet<>();
                            list.add(second);
                            wordToNeighbor.put(first, list);
                        }

                        if (wordToNeighbor.containsKey(second)) {
                            wordToNeighbor.get(second).add(first);
                        } else {
                            Set<String> list = new HashSet<>();
                            list.add(first);
                            wordToNeighbor.put(second, list);
                        }
                    }
                }
            }
        }

        HashSet<String> visitedWords = new HashSet<>();

        Queue<String> queue = new LinkedList<>();

        queue.add(beginWord);

        int step = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();
                visitedWords.add(word);

                if (word.equals(endWord)) {
                    return step + 1;
                }

                if (wordToNeighbor.containsKey(word)) {
                    for (String neigh : wordToNeighbor.get(word)) {
                        if (!visitedWords.contains(neigh))
                            queue.add(neigh);
                    }
                }
            }
            step++;
        }

        return 0;
    }

    private boolean hasOneChange(String beginWord, String currentWord) {

        int change = 0;
        for (int i = 0; i < beginWord.length(); i++) {
            if (beginWord.charAt(i) != currentWord.charAt(i)) {
                change++;
            }
        }
        return change == 1;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> list = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<String> wordList = new ArrayList<>();
        wordList.addAll(list);

        // String beginWord = "hit";
        // String endWord = "cog";
        // List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log",
        // "cog");
        // List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
        // List<String> wordList = Arrays.asList("si", "go", "se", "cm", "so", "ph",
        // "mt", "db", "mb", "sb", "kr", "ln",
        // "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa",
        // "yo", "ow", "sn", "ya",
        // "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc",
        // "lt", "lo", "as", "fr",
        // "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha",
        // "hz", "no", "bi", "di",
        // "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er",
        // "sc", "ne", "mn", "mi",
        // "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr",
        // "sq", "ye");

        System.out.println(new WordLadder().ladderLength(beginWord, endWord, wordList));

    }

}