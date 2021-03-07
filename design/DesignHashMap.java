package leetcode.design;

import java.util.Arrays;

/* https://leetcode.com/problems/design-hashmap/ */
/* Runtime: 11 ms, faster than 99.31% Memory Usage: 42.4 MB, less than 89.44% */
public class DesignHashMap {
    /* Runtime: 31 ms, faster than 32.51% Memory Usage: 46.1 MB, less than 37.41% */
    class MyHashMap {

        int[] values = null;

        /** Initialize your data structure here. */
        public MyHashMap() {
            values = new int[1000001];
            Arrays.fill(values, -1);
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            values[key] = value;
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map
         * contains no mapping for the key
         */
        public int get(int key) {
            return values[key];
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping
         * for the key
         */
        public void remove(int key) {
            values[key] = -1;
        }
    }

    /* Runtime: 11 ms, faster than 99.31% Memory Usage: 42.4 MB, less than 89.44% */
    class MyHashMapAlternate {

        final static int LIMIT = 10000;

        class Node {
            int key = -1;
            int value = -1;
            Node next = null;
        }

        Node[] nodes = null;

        /** Initialize your data structure here. */
        public MyHashMapAlternate() {
            nodes = new Node[LIMIT];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int keyMod = key % LIMIT;
            if (nodes[keyMod] == null) {
                // does not exist, create one
                nodes[keyMod] = new Node();
                nodes[keyMod].key = key;
                nodes[keyMod].value = value;
            } else {
                // check if real key exists or create new linkedlist node
                Node current = nodes[keyMod];
                Node prev = null;
                do {
                    if (current.key == key) {
                        current.value = value;
                        return;
                    }
                    prev = current;
                    current = current.next;
                } while (current != null);
                Node nextNode = new Node();
                nextNode.value = value;
                nextNode.key = key;
                prev.next = nextNode;
            }
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map
         * contains no mapping for the key
         */
        public int get(int key) {
            int keyMod = key % LIMIT;
            if (nodes[keyMod] != null) {
                Node current = nodes[keyMod];
                while (current != null) {
                    if (current.key == key) {
                        return current.value;
                    }
                    current = current.next;
                }
            }
            return -1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping
         * for the key
         */
        public void remove(int key) {
            int keyMod = key % LIMIT;
            Node current = nodes[keyMod];
            Node prev = null;
            while (current != null) {
                if (current.key == key) {
                    if (prev != null) {
                        prev.next = current.next;
                    } else {
                        nodes[keyMod] = current.next;
                        return;
                    }
                }
                prev = current;
                current = current.next;
            }
        }
    }
}
