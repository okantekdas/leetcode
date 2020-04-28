package leetcode.design;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/* https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3313/ */
public class FirstUnique {

    public class DoublyLinkedList {
        int value;
        DoublyLinkedList prev;
        DoublyLinkedList next;

        public DoublyLinkedList(int value) {
            this.value = value;
        }
    }

    DoublyLinkedList head = null;
    DoublyLinkedList tail = null;

    HashMap<Integer, DoublyLinkedList> valueToNode = new HashMap<>();

    public FirstUnique(int[] nums) {

        for (int num : nums) {
            add(num);
        }

    }

    public int showFirstUnique() {

        return head != null ? head.value : -1;
    }

    public void add(int value) {
        if (!valueToNode.containsKey(value)) {

            DoublyLinkedList node = new DoublyLinkedList(value);
            valueToNode.put(value, node);

            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }

        } else {
            DoublyLinkedList node = valueToNode.get(value);
            if (node != null) {
                if (node == tail) {
                    if (node != head) {
                        node.prev.next = null;
                        tail = node.prev;
                    } else {
                        tail = null;
                        head = null;
                    }

                } else {
                    if (node == head) {
                        node.next.prev = null;
                        head = node.next;
                    } else {
                        node.prev.next = node.next;
                        node.next.prev = node.prev;
                    }

                }

                valueToNode.put(value, null);
            }

        }
    }

    public static void main(String[] args)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String[] commands = { "showFirstUnique", "add", "add", "add", "add", "add", "showFirstUnique" };

        int[][] arguments = { {}, { 7 }, { 3 }, { 3 }, { 7 }, { 17 }, {} };
        int[] constructerArguments = { 7, 7, 7, 7, 7, 7 };
        FirstUnique firstUnique = new FirstUnique(constructerArguments);

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            int[] argumentArr = arguments[i];
            for (Method method : firstUnique.getClass().getDeclaredMethods()) {
                if (method.getName().equals(command)) {
                    if (method.getName().equals("showFirstUnique")) {
                        System.out.println(method.invoke(firstUnique));
                    } else {
                        method.invoke(firstUnique, argumentArr[0]);
                    }
                }
            }
        }
    }
}