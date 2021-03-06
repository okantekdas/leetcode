package leetcode.trie;

/* https://leetcode.com/problems/short-encoding-of-words/ */
/* Runtime: 9 ms, faster than 98.01% */
public class ShortEncodingOfWords {
    class Trie {
        Trie[] tries = new Trie[26];
        boolean isWord = false;
    }

    Trie root = new Trie();

    public int minimumLengthEncoding(String[] words) {

        int count = 0;
        for (String word : words) {
            Trie node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                if (node.tries[word.charAt(i) - 'a'] == null) {
                    node.tries[word.charAt(i) - 'a'] = new Trie();
                }
                node = node.tries[word.charAt(i) - 'a'];
            }
            node.isWord = true;

        }

        for (String word : words) {
            Trie node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                node = node.tries[word.charAt(i) - 'a'];
            }

            if (node.isWord) {
                count += word.length() + 1;
                for (Trie trie : node.tries) {
                    if (trie != null) {
                        count -= word.length() + 1;
                        break;
                    }
                }
                node.isWord = false;
            }

        }

        return count;
    }
}
