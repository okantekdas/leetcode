package leetcode.design;

import java.util.Iterator;

/* https://leetcode.com/problems/peeking-iterator/ */
/* Runtime: 4 ms, faster than 94.26% */
class PeekingIterator implements Iterator<Integer> {

    Integer current = null;

    Iterator<Integer> iterator = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()) {
            current = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return current;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int result = current;
        current = iterator.hasNext() ? iterator.next() : null;
        return result;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }
}
