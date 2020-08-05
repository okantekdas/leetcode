package leetcode.design;

public class AddAndSearchWord {

    class WordDictionary {

        class Trie {
            Trie[] children = new Trie[26];
            boolean isWord = false;
        }

        Trie root = null;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new Trie();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {

            char[] charArr = word.toCharArray();
            Trie node = root;
            for (int i = 0; i < charArr.length; i++) {
                char c = charArr[i];
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Trie();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot
         * character '.' to represent any one letter.
         */
        public boolean search(String word) {

            return search(word, root);

        }

        public boolean search(String word, Trie root) {
            if (word == null || word.isEmpty()) {
                return false;
            }

            if (word.charAt(0) == '.') {
                boolean result = false;
                for (int i = 0; i < root.children.length; i++) {
                    if (root.children[i] != null) {
                        if (root.children[i].isWord && word.length() == 1) {
                            return true;
                        }
                        result |= search(word.substring(1, word.length()), root.children[i]);
                    }
                }
                return result;

            } else if (root.children[word.charAt(0) - 'a'] == null) {
                return false;
            } else {
                if (root.children[word.charAt(0) - 'a'].isWord && word.length() == 1) {
                    return true;
                }
                return search(word.substring(1, word.length()), root.children[word.charAt(0) - 'a']);
            }

        }
    }

    static AddAndSearchWord asw = new AddAndSearchWord();

    public static void main(String[] args) {
        WordDictionary dictionary = asw.new WordDictionary();
        dictionary.addWord("at");
        dictionary.addWord("an");
        dictionary.addWord("add");
        System.out.println(dictionary.search("a"));
        System.out.println(dictionary.search(".at"));
        dictionary.addWord("bat");
        System.out.println(dictionary.search(".at"));

    }

}