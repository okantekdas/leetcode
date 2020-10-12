package leetcode.string;

/* https://leetcode.com/problems/buddy-strings */
/* Runtime: 1 ms, faster than 99.31%  */
public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {

        if ((A != null ^ B != null) || (A.length() != B.length())) {
            return false;
        }

        int prevDiff = 0;
        int currentDiff = 0;
        int[] charCounts = new int[26];
        boolean hasSameChar = false;
        for (int i = 0; i < A.length(); i++) {
            if (!hasSameChar) {
                if (charCounts[A.charAt(i) - 'a'] == 1) {
                    hasSameChar = true;
                } else {
                    charCounts[A.charAt(i) - 'a']++;
                }
            }
            if (A.charAt(i) != B.charAt(i)) {
                if (prevDiff == 0) {
                    prevDiff = A.charAt(i) - B.charAt(i);
                } else {
                    if (currentDiff != 0) {
                        return false;
                    } else {
                        currentDiff = B.charAt(i) - A.charAt(i);
                        if (currentDiff != prevDiff) {
                            return false;
                        }
                    }

                }

            }
        }

        if ((!hasSameChar && prevDiff == 0) || (prevDiff != 0 && currentDiff == 0)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new BuddyStrings().buddyStrings("abaaa", "abab"));
    }
}
