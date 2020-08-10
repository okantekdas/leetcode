package leetcode.other;

/* https://leetcode.com/problems/excel-sheet-column-number/ */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {

        char[] numsAsChar = s.toCharArray();

        int val = 0;
        for (int i = 0; i < numsAsChar.length; i++) {
            val += (numsAsChar[i] - 'A' + 1) * Math.pow(26, numsAsChar.length - i - 1);
        }

        return val;
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("FXSHRXW"));
    }

}