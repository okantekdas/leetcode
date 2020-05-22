package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/* https://leetcode.com/problems/sort-characters-by-frequency */
public class SortCharactersByFrequency {

    class CharCount {
        char c;
        int count;

        public CharCount(char c, int count) {
            this.c = c;
            this.count = count;
        }

    }

    public String frequencySort(String s) {

        PriorityQueue<CharCount> maxHeap = new PriorityQueue<>(new Comparator<CharCount>() {

            @Override
            public int compare(CharCount o1, CharCount o2) {
                if (o1.count > o2.count) {
                    return -1;
                } else if (o1.count == o2.count) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        int[] countByChar = new int[128];

        for (char c : s.toCharArray()) {
            countByChar[c]++;
        }
        for (int i = 0; i < 128; i++) {
            if (countByChar[i] > 0) {
                char c = (char) i;
                CharCount charCount = new CharCount(c, countByChar[c]);
                maxHeap.add(charCount);
            }

        }

        StringBuilder solution = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            CharCount charCount = maxHeap.poll();
            for (int i = 0; i < charCount.count; i++) {
                solution.append(charCount.c);
            }
        }

        return solution.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SortCharactersByFrequency().frequencySort("tree"));
    }
}