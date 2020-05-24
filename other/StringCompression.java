package leetcode.other;

/* https://leetcode.com/problems/string-compression/ */
public class StringCompression {
    public int compress(char[] chars) {

        int firstIndex = 0;
        int lastIndex = 1;

        int writeIndex = 0;
        while (lastIndex < chars.length) {
            char currentChar = chars[lastIndex];
            if (currentChar != chars[firstIndex]) {
                chars[writeIndex++] = chars[firstIndex];
                if (lastIndex - 1 != firstIndex) {

                    int repeatCount = lastIndex - firstIndex;
                    String repeatCountStr = "" + repeatCount;
                    for (char c : repeatCountStr.toCharArray()) {
                        chars[writeIndex++] = c;
                    }
                }
                firstIndex = lastIndex;
            }
            lastIndex++;
        }

        chars[writeIndex++] = chars[firstIndex];
        if (lastIndex - 1 != firstIndex) {

            int repeatCount = lastIndex - firstIndex;
            String repeatCountStr = "" + repeatCount;
            for (char c : repeatCountStr.toCharArray()) {
                chars[writeIndex++] = c;
            }
        }
        firstIndex = lastIndex;

        return writeIndex;

    }

    public static void main(String[] args) {
        // char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        // char[] chars = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b',
        // 'b' };
        // char[] chars = { 'a', 'a', 'a', 'b', 'b', 'a', 'a' };
        char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'a',
                'b', 'c' };

        System.out.println(new StringCompression().compress(chars));
    }
}