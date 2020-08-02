package leetcode.other;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {

        char[] charArr = word.toCharArray();
        boolean isFirstUpper = charArr[0] < 97;
        int upperCount = 0;
        for (int i = 1; i < charArr.length; i++) {
            if (charArr[i] < 97) {
                upperCount++;
            }
        }

        boolean result = false;
        if (isFirstUpper && (upperCount == charArr.length - 1 || upperCount == 0)) {
            result = true;
        } else if (!isFirstUpper && upperCount == 0) {
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        String word = "flAg";

        System.out.println(new DetectCapital().detectCapitalUse(word));
    }
}