package leetcode.other;

/**
 * RepeatedSubstringPattern
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {

        int length = s.length();
        for (int i = length / 2; i > 0; i--) {
            if (i != 0 && (length / i) * i != length) {
                continue;
            } else {

                for (int j = i; j <= length; j += i) {
                    if (!s.substring(0, i).equals(s.substring(j, j + i))) {
                        break;
                    }
                    if (j + i == length) {
                        return true;
                    }
                }

            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern(s));
    }

}