package leetcode.other;

/* https://leetcode.com/problems/remove-k-digits */
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        StringBuilder strBuilder = new StringBuilder();

        if (num.length() <= k) {
            strBuilder.append('0');
            return strBuilder.toString();
        }

        int index = 0;
        int lastAddedIndex = -1;
        while (index < num.length()) {

            char c = num.charAt(index);

            while (strBuilder.length() > 0 && k > 0) {
                if (strBuilder.charAt(lastAddedIndex) > c) {

                    strBuilder.deleteCharAt(lastAddedIndex);
                    lastAddedIndex--;
                    k--;

                } else {
                    break;
                }
            }

            if (strBuilder.length() == 0 && c == '0') {
                index++;
                continue;
            }
            strBuilder.append(c);
            lastAddedIndex++;
            index++;
        }

        if (k != 0) {
            String str = strBuilder.substring(0, strBuilder.length() - k);
            strBuilder = new StringBuilder();
            strBuilder.append(str);
        }

        if (strBuilder.length() == 0) {
            strBuilder.append('0');
        }
        return strBuilder.toString();

    }

    public static void main(String[] args) {

        String num = "112";
        int k = 2;

        System.out.println(new RemoveKDigits().removeKdigits(num, k));
    }

}