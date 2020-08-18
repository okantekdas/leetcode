package leetcode.other;

import java.util.Arrays;

/* https://leetcode.com/problems/distribute-candies-to-people */
public class DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int[] solution = new int[num_people];
        int index = 0;
        int candyCount = 1;
        while (candies > 0) {
            if (index == num_people) {
                index = 0;
            } else {
                if (candies >= candyCount) {
                    candies -= candyCount;
                    solution[index++] += candyCount++;
                } else {
                    solution[index++] += candies;
                    candies = 0;
                }

            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int[] solution = new DistributeCandiesToPeople().distributeCandies(10, 3);
        System.out.println(Arrays.toString(solution));
    }
}