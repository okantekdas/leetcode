package leetcode.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/* https://leetcode.com/problems/top-k-frequent-elements */
public class TopKFrequentElements {
    public class Element {
        int val;
        int count;
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> solution = new ArrayList<>();

        HashMap<Integer, Integer> numberToCounter = new HashMap<>();

        for (int num : nums) {
            Integer count = numberToCounter.get(num);
            if (count == null) {
                numberToCounter.put(num, 1);
            } else {
                numberToCounter.put(num, ++count);
            }
        }

        PriorityQueue<Element> elementQueue = new PriorityQueue<>(new Comparator<Element>() {

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
        for (int num : numberToCounter.keySet()) {
            Element element = new Element();
            element.val = num;
            element.count = numberToCounter.get(num);
            elementQueue.add(element);
        }

        for (int i = 0; i < k; i++) {
            solution.add(elementQueue.poll().val);
        }

        return solution;
    }

}
