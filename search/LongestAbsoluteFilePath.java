package leetcode.search;

/* https://leetcode.com/problems/longest-absolute-file-path/ */
public class LongestAbsoluteFilePath {

    int index = 0;

    public int lengthLongestPath(String input) {

        return lengthLongestPath(input, 0, 0);
    }

    public int lengthLongestPath(String input, int level, int total) {

        int start = index;
        int max = 0;
        int length = -1;
        String subDir = "";
        while (index < input.length()) {

            if (input.charAt(index) == '\n') {

                if (length == -1) {
                    length = index - start;
                    subDir = input.substring(start, index);
                }
                System.out.println(subDir);

                int counter = 0;
                int tempIndex = index + 1;
                while (input.charAt(tempIndex) == '\t') {
                    counter++;
                    tempIndex++;
                }
                if (counter == level + 1) {
                    index = tempIndex;
                    max = Math.max(max, lengthLongestPath(input, level + 1, total + length + 1));
                } else {
                    if (counter == level) {
                        max = subDir.contains(".") ? Math.max(max, total + length) : max;
                        index = tempIndex;
                        max = Math.max(max, lengthLongestPath(input, level, total));
                    } else {
                        return subDir.contains(".") ? Math.max(max, total + length) : max;
                    }

                }
            } else if (index == input.length() - 1) {
                index++;
                if (length == -1) {
                    length = index - start;
                    subDir = input.substring(start, index);
                }
                System.out.println(subDir);

                return subDir.contains(".") ? Math.max(max, total + length) : max;

            } else {
                index++;
            }

        }

        return max;
    }

    public static void main(String[] args) {
        String input = "dir\n\t        file.txt\n\tfile2.txt";
        // String input = "dir\n file.txt";
        System.out.println(new LongestAbsoluteFilePath().lengthLongestPath(input));
    }
}