package leetcode.other;

import java.util.HashMap;

/* https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/ */
public class CountTripletsThatCanFormTwoArraysOfEqualXOR {

    class Memo {
        int left, right;

        public Memo(int left, int right) {
            this.left = left;
            this.right = right;

        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + left;
            result = prime * result + right;

            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Memo other = (Memo) obj;
            if (left != other.left)
                return false;
            if (right != other.right)
                return false;
            return true;
        }

    }

    HashMap<Memo, Integer> solutions = new HashMap<>();

    public int countTriplets(int[] arr) {

        calculateTriplets(arr, 0, arr.length - 1);
        return count;
    }

    int count = 0;

    public int calculateTriplets(int[] arr, int left, int right) {

        if (left == right) {
            return arr[left];
        }

        Memo memo = new Memo(left, right);
        if (solutions.containsKey(memo)) {
            return solutions.get(memo);
        }

        int mid = left;
        int leftSolution = 0;
        int rightSolution = 0;

        while (mid < right) {
            leftSolution = calculateTriplets(arr, left, mid);
            rightSolution = calculateTriplets(arr, mid + 1, right);

            if (leftSolution == rightSolution) {

                if (!solutions.containsKey(memo)) {
                    count++;
                }
            }
            mid++;
        }

        int solution = leftSolution ^ rightSolution;
        solutions.put(memo, solution);

        return solution;
    }

    public static void main(String[] args) {

        // int[] arr = { 2, 3, 1 };
        // int[] arr = { 2, 3, 1, 6, 7 };
        int[] arr = { 7, 11, 12, 9, 5, 2, 7, 17, 22 };

        System.out.println(new CountTripletsThatCanFormTwoArraysOfEqualXOR().countTriplets(arr));

    }

}