package leetcode.twopointers;

/* Runtime: 8 ms, faster than 75.52% of Java online submissions for Push Dominoes.
Memory Usage: 40.1 MB, less than 73.45% */
public class PushDominoes {

    public String pushDominoes(String dominoes) {

        char[] characters = new char[dominoes.length() + 2];
        int i = 0;
        characters[i++] = 'L';
        for (char c : dominoes.toCharArray()) {
            characters[i++] = c;
        }
        characters[i] = 'R';

        int left = 0;
        int right = 1;

        while (right < characters.length) {
            if (characters[right] == '.') {
                right++;
            } else {
                if (characters[left] == 'L') {
                    if (characters[right] == 'L') {
                        left++;
                        while (left < right) {
                            characters[left++] = characters[right];
                        }
                    } else {
                        // do nothing
                    }
                } else {
                    if (characters[right] == 'R') {
                        left++;
                        while (left <= right) {
                            characters[left++] = characters[right];
                        }
                    } else {
                        int rightMost = right - 1;
                        int leftMost = left + 1;
                        while (leftMost < rightMost) {
                            characters[leftMost] = characters[leftMost - 1];
                            characters[rightMost] = characters[rightMost + 1];
                            leftMost++;
                            rightMost--;
                        }
                    }
                }
                left = right;
                right++;
            }
        }

        return String.valueOf(characters).substring(1, characters.length - 1);
    }

    public static void main(String[] args) {

        String dominoes = "RR.L";
        System.out.println(new PushDominoes().pushDominoes(dominoes));

    }
}
