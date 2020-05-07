package leetcode.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* https://leetcode.com/problems/partition-labels */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {

        HashMap<Character, Integer> charToIndexes = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            char current = S.charAt(i);
            charToIndexes.put(current, i);
        }

        List<Integer> solution = new ArrayList<>();
        char leftChar = S.charAt(0);
        int left = 0;
        int right = charToIndexes.get(leftChar);
        int leftMost = left;
        while (right <= S.length() - 1) {
            if (left < right) {
                char current = S.charAt(left);
                if (current != leftChar) {
                    if (charToIndexes.get(current) > right) {
                        leftChar = current;
                        right = charToIndexes.get(current);
                    }
                }
            } else {

                solution.add(right - leftMost + 1);

                if (left + 1 < S.length()) {
                    leftChar = S.charAt(left + 1);
                    leftMost = left + 1;
                    right = charToIndexes.get(leftChar);
                } else {
                    break;
                }

            }
            left++;

        }

        return solution;
    }

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";

        System.out.println(new PartitionLabels().partitionLabels(S));

    }
}