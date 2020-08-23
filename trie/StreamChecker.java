package leetcode.trie;

public class StreamChecker {

    class Trie {
        Trie[] tries = new Trie[26];
        boolean isWord = false;
    }

    Trie root = null;
    // List<Character> characters = new ArrayList<>();
    StringBuilder strBuilder = new StringBuilder();
    int maxLength = 0;

    public StreamChecker(String[] words) {
        root = new Trie();
        for (String word : words) {
            Trie node = root;
            int length = 0;

            for (int i = word.length() - 1; i > -1; i--) {
                if (node.tries[word.charAt(i) - 'a'] == null) {
                    node.tries[word.charAt(i) - 'a'] = new Trie();
                }
                node = node.tries[word.charAt(i) - 'a'];
                length++;
            }
            maxLength = Math.max(maxLength, length);
            node.isWord = true;
        }

    }

    public boolean query(char letter) {
        strBuilder.append(letter);
        Trie node = root;
        for (int i = strBuilder.length() - 1; i > -1 && strBuilder.length() - 1 >= maxLength; i--) {

            if (node.tries[strBuilder.charAt(i) - 'a'] == null) {
                return false;
            }
            node = node.tries[strBuilder.charAt(i) - 'a'];
            if (node.isWord) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        String[] words = { "cd", "f", "kl" };
        StreamChecker streamChecker = new StreamChecker(words);
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('c'));
        System.out.println(streamChecker.query('d'));

        System.out.println(streamChecker.query('e'));
        System.out.println(streamChecker.query('f'));

        System.out.println(streamChecker.query('g'));
        System.out.println(streamChecker.query('h'));
        System.out.println(streamChecker.query('i'));
        System.out.println(streamChecker.query('j'));
        System.out.println(streamChecker.query('k'));
        System.out.println(streamChecker.query('l'));

    }

}