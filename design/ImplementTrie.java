package leetcode.design;

import java.util.HashMap;

/* https://leetcode.com/problems/implement-trie-prefix-tree/ */
public class ImplementTrie {

    /** Initialize your data structure here. */
    class Trie {

        Character character = null;
        HashMap<Character, Trie> charToTrie;
        Trie root = null;
        boolean isEnd = false;

        /** Initialize your data structure here. */
        public Trie() {
            charToTrie = new HashMap<>();
            root = this;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {

            Trie current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Trie next = current.charToTrie.get(c);
                if (next == null) {
                    next = new Trie();
                    next.character = c;
                    current.charToTrie.put(c, next);
                }
                current = next;
            }
            current.isEnd = true;

        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {

            Trie current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Trie next = current.charToTrie.get(c);
                if (next == null) {
                    return false;
                }
                current = next;
            }

            return current.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Trie current = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                Trie next = current.charToTrie.get(c);
                if (next == null) {
                    return false;
                }
                current = next;
            }
            return true;
        }
    }

    static ImplementTrie it = new ImplementTrie();

    public static void main(String[] args) {

        Trie trie = it.new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple")); // returns true
        System.out.println(trie.search("app")); // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app")); // returns true

    }

}