package leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/* https://leetcode.com/problems/distant-barcodes/ */
public class DistantBarcodes {

    public class Element {
        int val;
        int count;
    }

    public int[] rearrangeBarcodes(int[] barcodes) {

        HashMap<Integer, Integer> charToCount = new HashMap<>();
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

        for (int barcode : barcodes) {

            Integer count = charToCount.get(barcode);
            if (count == null) {
                charToCount.put(barcode, 1);
            } else {
                charToCount.put(barcode, ++count);
            }
        }

        for (int barcode : charToCount.keySet()) {
            Element element = new Element();
            element.val = barcode;
            element.count = charToCount.get(barcode);
            heap.add(element);

        }

        int[] orderedBarcodes = new int[barcodes.length];
        int i = 0;
        while (heap.size() > 0) {
            Element first = heap.poll();
            Element second = heap.poll();

            orderedBarcodes[i++] = first.val;
            if (second == null) {
                break;
            }
            orderedBarcodes[i++] = second.val;
            first.count--;
            second.count--;
            if (first.count > 0) {
                heap.add(first);
            }
            if (second.count > 0) {
                heap.add(second);
            }

        }

        return orderedBarcodes;

    }

    public static void main(String[] args) {

        int[] barcodes = { 1, 1, 1, 2, 2, 2 };

        System.out.println(Arrays.toString(new DistantBarcodes().rearrangeBarcodes(barcodes)));

    }

}