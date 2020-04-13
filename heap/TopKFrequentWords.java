package leetcode.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords {

    public class Element {
        String val;
        int count;
    }

    public List<String> topKFrequent(String[] words, int k) {

        List<String> solution = new ArrayList<>();

        HashMap<String, Integer> numberToCounter = new HashMap<>();

        for (String word : words) {
            Integer count = numberToCounter.get(word);
            if (count == null) {
                numberToCounter.put(word, 1);
            } else {
                numberToCounter.put(word, ++count);
            }
        }

        PriorityQueue<Element> elementQueue = new PriorityQueue<>(new Comparator<Element>() {

            @Override
            public int compare(Element o1, Element o2) {
                if (o1.count > o2.count)
                    return -1;
                else if (o1.count == o2.count) {
                    return o1.val.compareTo(o2.val);
                } else {
                    return 1;
                }
            }
        });
        for (String word : numberToCounter.keySet()) {
            Element element = new Element();
            element.val = word;
            element.count = numberToCounter.get(word);
            elementQueue.add(element);
        }

        for (int i = 0; i < k; i++) {
            solution.add(elementQueue.poll().val);
        }

        return solution;

    }

}