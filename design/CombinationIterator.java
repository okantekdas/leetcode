package leetcode.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* https://leetcode.com/problems/iterator-for-combination */
public class CombinationIterator {

    int index = 0;
    List<String> solution = null;

    public CombinationIterator(String characters, int combinationLength) {
        index = 0;
        solution = calculateCombinations(characters, combinationLength);
    }

    public List<String> calculateCombinations(String characters, int combinationLength) {
        List<String> subsolution = new ArrayList<>();
        if (combinationLength == 0) {
            return subsolution;
        }
        if (characters == null || characters.isEmpty() || characters.length() < combinationLength) {
            return null;
        }

        for (int i = 0; i < characters.length(); i++) {
            List<String> combinations = calculateCombinations(characters.substring(i + 1, characters.length()),
                    combinationLength - 1);
            if (combinations == null) {
                break;
            }
            for (String str : combinations) {
                subsolution.add(characters.charAt(i) + str);
            }
            if (combinations.isEmpty()) {
                subsolution.add(String.valueOf(characters.charAt(i)));
            }
        }

        return subsolution;
    }

    public String next() {

        if (solution != null && index < solution.size()) {
            return solution.get(index++);
        }

        return null;
    }

    public boolean hasNext() {

        if (solution != null && index < solution.size()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(new CombinationIterator("abcd", 2).calculateCombinations("fiklnuy", 3)));
    }
}