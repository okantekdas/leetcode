package leetcode.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/* https://leetcode.com/problems/reorganize-string/ */
public class ReorganizeString {

    public class Element {
        Character val;
        int count;
    }

    public String reorganizeString(String S) {

        if (S.length() == 1) {
            return S;
        }

        HashMap<Character, Integer> charToCount = new HashMap<>();
        PriorityQueue<Element> heap = new PriorityQueue<>(new Comparator<Element>() {

            @Override
            public int compare(Element o1, Element o2) {
                if (o1.count > o2.count)
                    return -1;
                else if (o1.count == o2.count) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        for (Character c : S.toCharArray()) {

            Integer count = charToCount.get(c);
            if (count == null) {
                charToCount.put(c, 1);
            } else {
                charToCount.put(c, ++count);
            }
        }

        for (Character c : charToCount.keySet()) {
            Element element = new Element();
            element.val = c;
            element.count = charToCount.get(c);
            heap.add(element);

        }

        StringBuilder strBuilder = new StringBuilder();

        while (heap.size() > 0) {
            Element first = heap.poll();
            Element second = heap.peek();

            strBuilder.append(first.val);
            if (second == null) {
                break;
            } else {
                second = heap.poll();
            }
            strBuilder.append(second.val);
            first.count--;
            second.count--;
            if (first.count > 0) {
                heap.add(first);
            }
            if (second.count > 0) {
                heap.add(second);
            }

        }
        if (strBuilder.length() == S.length()) {
            return strBuilder.toString();
        } else {
            return "";
        }

    }

    public static void main(String[] args) {
        String S = "aaab";

        System.out.println(new ReorganizeString().reorganizeString(S));
    }

}