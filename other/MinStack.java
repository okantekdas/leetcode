package leetcode.other;

import java.util.PriorityQueue;

public class MinStack {
    /* https://leetcode.com/problems/min-stack/ */

    public class Node {
        int value;
        Node next;
        Node previous;

    }

    int min = Integer.MIN_VALUE;
    Node recent;
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {

        queue.add(x);
        Node node = new Node();
        node.value = x;
        if (recent != null) {
            recent.next = node;
            node.previous = recent;
        }
        recent = node;

    }

    public void pop() {
        if (recent != null) {
            if (queue != null) {
                queue.remove(recent.value);
            }
            Node previous = recent.previous;
            if (previous != null) {
                previous.next = null;
            }

            recent = previous;
        }

    }

    public int top() {
        return recent == null ? 0 : recent.value;
    }

    public int getMin() {
        return queue.peek() == null ? 0 : queue.peek();
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        minStack.top();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.push(2147483647);
        minStack.top();
        minStack.getMin();
        minStack.push(-2147483648);
        minStack.top();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();

    }

}