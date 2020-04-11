package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    static final char[][] numberToLetter = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
            { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

    List<String> solutions = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return solutions;
        }

        calculateLetterCombinations(digits.length(), digits, "");
        return solutions;
    }

    public void calculateLetterCombinations(int length, String digits, String combination) {

        if (combination.length() == length) {
            solutions.add(combination);
            return;
        }

        char currentDigit = digits.charAt(0);
        char[] currentCharArr = numberToLetter[Character.getNumericValue(currentDigit) - 2];
        for (char currentChar : currentCharArr) {
            if (digits.length() > 1) {
                calculateLetterCombinations(length, digits.substring(1), combination + currentChar);
            } else {
                calculateLetterCombinations(length, "", combination + currentChar);
            }

        }

    }

    public static void main(String[] args) {

        List<String> solutions = new LetterCombinationsOfPhoneNumber().letterCombinations("23");
        System.out.println(Arrays.toString(solutions.toArray()));

    }

}