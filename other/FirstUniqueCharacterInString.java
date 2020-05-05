package leetcode.other;

import java.util.Arrays;
import java.util.LinkedList;

/* https://leetcode.com/problems/first-unique-character-in-a-string/ */
public class FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {

        int[] charIndexes = new int[26];
        Arrays.fill(charIndexes, -1);
        LinkedList<Integer> uniques = new LinkedList<>();

        char[] sChar = s.toCharArray();
        for (int i = 0; i < sChar.length; i++) {
            char current = sChar[i];
            if (charIndexes[current - 97] == -1) {
                charIndexes[current - 97] = i;
                uniques.add(i);
            } else {
                uniques.remove(new Integer(charIndexes[current - 97]));
            }
        }
        return uniques.peek() == null ? -1 : uniques.peek();
    }

    public static void main(String[] args) {

        String s = "loveleetcode";

        System.out.println(new FirstUniqueCharacterInString().firstUniqChar(s));

    }
}