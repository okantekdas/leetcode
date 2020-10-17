package leetcode.hashtable;

import java.util.HashSet;

/* https://leetcode.com/problems/repeated-dna-sequences/ */
/* Runtime: 15 ms, faster than 88.33% */
import java.util.List;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seenSet = new HashSet<>();
        HashSet<String> repeatedSet = new HashSet<>();

        for (int i = 0; i + 9 < s.length(); i++) {
            String str = s.substring(i, i + 10);
            if (seenSet.contains(str)) {
                repeatedSet.add(str);
            } else {
                seenSet.add(str);
            }
        }

        return List.copyOf(repeatedSet);
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences(s));
    }
}
