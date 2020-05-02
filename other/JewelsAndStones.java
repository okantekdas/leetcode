package leetcode.other;

import java.util.HashMap;

/* https://leetcode.com/problems/jewels-and-stones/ */
public class JewelsAndStones {

    HashMap<Character, Integer> stoneToCount = new HashMap<>();

    public int numJewelsInStones(String J, String S) {

        for (char c : S.toCharArray()) {
            Integer count = stoneToCount.get(c);
            if (count == null) {
                count = new Integer(0);
                stoneToCount.put(c, count);
            }
            stoneToCount.put(c, ++count);
        }

        int counter = 0;
        for (char c : J.toCharArray()) {
            if (stoneToCount.containsKey(c)) {
                counter += stoneToCount.get(c);
            }
        }

        return counter;
    }

    public static void main(String[] args) {

        String S = "aAAbbbb";
        String J = "ab";

        System.out.println(new JewelsAndStones().numJewelsInStones(J, S));
    }

}