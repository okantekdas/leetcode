package leetcode.other;

/* https://leetcode.com/problems/ransom-note */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        int[] characters = new int[25];

        for (char c : magazine.toCharArray()) {
            characters[c - 97]++;
        }

        for (char c : ransomNote.toCharArray()) {
            characters[c - 97]--;
            if (characters[c - 97] < 0) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";

        System.out.println(new RansomNote().canConstruct(ransomNote, magazine));
    }

}