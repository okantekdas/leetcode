package leetcode.design;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* https://leetcode.com/problems/design-circular-queue/ */
public class DesignCircularQueue {

    class MyCircularQueue {

        int[] array;
        int headIndex = 0;
        int tailIndex = -1;
        int size = 0;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            array = new int[k];
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is
         * successful.
         */
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            size++;
            tailIndex = ++tailIndex % array.length;
            array[tailIndex] = value;

            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is
         * successful.
         */
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            size--;
            headIndex = ++headIndex % array.length;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return array[headIndex];
        }

        /** Get the last item from the queue. */
        public int Rear() {

            if (isEmpty()) {
                return -1;
            }
            return array[tailIndex];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {

            return size == 0;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return size == array.length;
        }
    }

    static DesignCircularQueue dcq = new DesignCircularQueue();

    public static void main(String[] args)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        String[] commands = { "MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull",
                "deQueue", "enQueue", "Rear" };

        int[][] arguments = { { 3 }, { 1 }, { 2 }, { 3 }, { 4 }, {}, {}, {}, { 4 }, {} };

        // String[] commands = { "MyCircularQueue", "enQueue", "Rear", "Rear",
        // "deQueue", "enQueue", "Rear", "deQueue",
        // "Front", "deQueue", "deQueue", "deQueue" };

        // int[][] arguments = { { 6 }, { 6 }, {}, {}, {}, { 5 }, {}, {}, {}, {}, {}, {}
        // };

        MyCircularQueue myCircularQueue = dcq.new MyCircularQueue(arguments[0][0]);

        for (int i = 1; i < commands.length; i++) {
            String command = commands[i];
            int[] argumentArr = arguments[i];

            for (Method method : myCircularQueue.getClass().getDeclaredMethods()) {
                if (method.getName().equals(command)) {
                    if (argumentArr.length == 0) {
                        System.out.println(method.invoke(myCircularQueue));
                    } else {
                        System.out.println(method.invoke(myCircularQueue, argumentArr[0]));
                    }

                }

            }
        }
    }

}