package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/* https://leetcode.com/problems/permutations-ii/ */
/* Runtime: 5 ms, faster than 27.79% */
public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = Arrays.stream(nums) // IntStream
                .boxed() // Stream<Integer>
                .collect(Collectors.toList());
        return permuteUnique(list);
    }

    public List<List<Integer>> permuteUnique(List<Integer> numbers) {

        List<List<Integer>> solution = new ArrayList<>();
        if (numbers.isEmpty()) {
            solution.add(new ArrayList<>());
        }

        Set<Integer> usedSet = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            if (!usedSet.contains(number)) {
                usedSet.add(number);
                List<Integer> nextNumbers = new ArrayList<>(numbers);
                nextNumbers.remove(i);
                List<List<Integer>> subsolutions = permuteUnique(nextNumbers);

                for (List<Integer> subsolution : subsolutions) {
                    subsolution.add(number);
                }
                solution.addAll(subsolutions);
            }
        }

        return solution;

    }

    public static void main(String[] args) {

        int[] nums = { 1, 1, 2 };

        new Permutations2().permuteUnique(nums);
    }

}
