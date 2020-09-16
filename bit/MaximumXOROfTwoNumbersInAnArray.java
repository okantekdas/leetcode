package leetcode.bit;

/* https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array */
public class MaximumXOROfTwoNumbersInAnArray {
    class Trie {
        Trie[] tries = new Trie[2];
    }

    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Trie root = new Trie();

        for (int num : nums) {
            Trie current = root;
            for (int i = 31; i >= 0; i--) {

                int currentBit = (num >> i) & 1;
                if (current.tries[currentBit] == null) {
                    current.tries[currentBit] = new Trie();
                }
                current = current.tries[currentBit];

            }
        }

        int max = 0;
        for (int num : nums) {
            Trie current = root;
            int localSum = 0;
            for (int i = 31; i >= 0; i--) {
                int currentBit = (num >> i) & 1;
                if (current.tries[currentBit ^ 1] != null) {
                    localSum += (1 << i);
                    current = current.tries[currentBit ^ 1];
                } else {
                    current = current.tries[currentBit];

                }
            }
            max = Math.max(max, localSum);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 10, 5, 25, 2, 8 };
        System.out.println(new MaximumXOROfTwoNumbersInAnArray().findMaximumXOR(nums));
    }
}
