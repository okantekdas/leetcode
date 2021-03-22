package leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;

/* https://leetcode.com/problems/vowel-spellchecker/ */
/* Runtime: 19 ms, faster than 75.12% Memory Usage: 42.8 MB, less than 87.19% */
public class VowelSpellchecker {

    public String[] spellchecker(String[] wordlist, String[] queries) {

        HashSet<String> words = new HashSet<>();
        HashMap<String, String> lowerToOriginal = new HashMap<>();
        HashMap<String, String> vowelToOriginal = new HashMap<>();

        for (String word : wordlist) {
            words.add(word);
            lowerToOriginal.putIfAbsent(word.toLowerCase(), word);
            vowelToOriginal.putIfAbsent(substitueVowels(word.toLowerCase()), word);
        }

        String[] result = new String[queries.length];
        int index = 0;
        for (String query : queries) {
            String queryLower = query.toLowerCase();
            String queryVowel = substitueVowels(queryLower);
            if (words.contains(query)) {
                result[index] = query;
            } else if (lowerToOriginal.containsKey(queryLower)) {
                result[index] = lowerToOriginal.get(queryLower);
            } else if (vowelToOriginal.containsKey(queryVowel)) {
                result[index] = vowelToOriginal.get(queryVowel);
            } else {
                result[index] = "";
            }
            index++;
        }
        return result;
    }

    private String substitueVowels(String word) {
        StringBuilder strBuilder = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                strBuilder.append('*');
            } else {
                strBuilder.append(c);
            }
        }

        return strBuilder.toString();
    }

}
