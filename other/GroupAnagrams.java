package leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return null;
        }

        HashMap<String, List<String>> strToAnagram = new HashMap<>();

        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedStr = String.valueOf(charArr);
            List<String> anagrams = strToAnagram.get(sortedStr);
            if (anagrams == null) {
                anagrams = new ArrayList<>();
                strToAnagram.put(sortedStr, anagrams);
            }
            anagrams.add(str);

        }

        List<List<String>> solution = new ArrayList<>();
        for (List<String> anagramGroup : strToAnagram.values()) {
            solution.add(anagramGroup);
        }

        return solution;
    }

    public static void main(String[] args) {
        String[] strs = { "eat" };

        System.out.println(Arrays.deepToString(new GroupAnagrams().groupAnagrams(strs).toArray()));

    }

}