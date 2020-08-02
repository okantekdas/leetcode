package leetcode.design;

public class DesignHashSet {
    class MyHashSet {
        private boolean arr[][];

        /** Initialize your data structure here. */
        public MyHashSet() {
            arr = new boolean[10000][101];

        }

        public void add(int key) {
            arr[key % 10000][key % 101] = true;
        }

        public void remove(int key) {
            arr[key % 10000][key % 101] = false;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return arr[key % 10000][key % 101];
        }

    }

    public static void main(String[] args) {

    }
}