package leetcode.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/* https://leetcode.com/problems/insert-delete-getrandom-o1/ */
public class InsertDeleteGetRandom {

    class RandomizedSet {

        HashMap<Integer, Integer> numToPosition;
        ArrayList<Integer> list;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            numToPosition = new HashMap<>();
            list = new ArrayList<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain
         * the specified element.
         */
        public boolean insert(int val) {
            if (numToPosition.containsKey(val)) {
                return false;
            } else {
                list.add(val);
                numToPosition.put(val, list.size() - 1);
                return true;
            }

        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified
         * element.
         */
        public boolean remove(int val) {

            if (!numToPosition.containsKey(val)) {
                return false;
            } else {
                int lastNum = list.get(list.size() - 1);
                int posToReplace = numToPosition.get(val);
                list.set(posToReplace, lastNum);
                numToPosition.put(lastNum, posToReplace);
                numToPosition.remove(val);
                list.remove(list.size() - 1);
                return true;
            }
        }

        /** Get a random element from the set. */
        public int getRandom() {

            double random = new Random().nextDouble();

            return list.get((int) (random * list.size() - 1));
        }
    }

}