package leetcode.other;

/**
 * BackspaceStringCompare
 */
public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {

        int sIndex = S.length() - 1;
        int tIndex = T.length() - 1;
        while (0 <= sIndex || 0 <= tIndex) {

            int bsCounterS = 0;
            while (0 <= sIndex) {
                if (S.charAt(sIndex) == '#') {
                    bsCounterS++;
                } else {
                    if (bsCounterS == 0) {
                        break;
                    } else {
                        bsCounterS--;
                    }

                }
                sIndex--;

            }

            int bsCounterT = 0;
            while (0 <= tIndex) {
                if (T.charAt(tIndex) == '#') {
                    bsCounterT++;
                } else {
                    if (bsCounterT == 0) {
                        break;
                    } else {
                        bsCounterT--;
                    }

                }
                tIndex--;

            }

            if (sIndex >= 0 && tIndex >= 0 && S.charAt(sIndex) != T.charAt(tIndex)) {
                return false;
            }

            if ((sIndex >= 0) != (tIndex >= 0))
                return false;

            sIndex--;
            tIndex--;

        }

        return true;

    }

    public static void main(String[] args) {

        String str1 = "nzp#o#g";
        String str2 = "b#nzp#o#g";

        System.out.println("Result: " + new BackspaceStringCompare().backspaceCompare(str1, str2));

    }

}