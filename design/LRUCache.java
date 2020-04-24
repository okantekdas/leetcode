package leetcode.design;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/* https://leetcode.com/problems/lru-cache/ */
public class LRUCache {

    public class DoublyLinkedList {

        int key;
        int value;
        DoublyLinkedList prev;
        DoublyLinkedList next;

        public DoublyLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity = 0;

    HashMap<Integer, DoublyLinkedList> keyToNode;
    DoublyLinkedList head = null;
    DoublyLinkedList tail = null;

    public LRUCache(int capacity) {
        keyToNode = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (keyToNode.get(key) == null) {
            return -1;
        } else {
            put(key, keyToNode.get(key).value);
            return keyToNode.get(key).value;
        }

    }

    public void put(int key, int value) {
        if (head == null) {
            head = new DoublyLinkedList(key, value);
            tail = head;
            keyToNode.put(key, head);
            return;
        }

        DoublyLinkedList node = keyToNode.get(key);

        if (node == null) {
            if (keyToNode.size() < capacity) {
                node = new DoublyLinkedList(key, value);
                node.next = head;
                head.prev = node;
                keyToNode.put(key, node);
                head = node;
            } else {
                keyToNode.remove(tail.key);
                if (tail.prev != null) {
                    tail.prev.next = null;
                }
                tail = tail.prev;
                put(key, value);
            }
        } else {
            node.value = value;
            if (node == head) {
                return;
            } else {
                node.prev.next = node.next;
                if (node != tail) {
                    node.next.prev = node.prev;
                }
            }
            if (node == tail) {
                tail = node.prev;
                if (tail == null) {
                    tail = node;
                }
            }
            node.next = head;
            node.prev = null;
            head.prev = node;
            keyToNode.put(key, node);
            head = node;
        }

    }

    public static void main(String[] args)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String[] commands = { "LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get" };

        int[][] arguments = { { 2 }, { 1, 1 }, { 2, 2 }, { 1 }, { 3, 3 }, { 2 }, { 4, 4 }, { 1 }, { 3 }, { 4 } };

        LRUCache cache = new LRUCache(arguments[0][0]);

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            int[] argumentArr = arguments[i];
            for (Method method : cache.getClass().getDeclaredMethods()) {
                if (method.getName().equals(command)) {
                    if (method.getName().equals("get")) {
                        System.out.println(method.invoke(cache, argumentArr[0]));
                    } else {
                        method.invoke(cache, argumentArr[0], argumentArr[1]);
                    }

                }

            }
        }
    }

}