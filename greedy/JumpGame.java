package leetcode.greedy;

import java.util.HashMap;

/* https://leetcode.com/problems/jump-game/ */
public class JumpGame {

    public boolean canJump(int[] nums) {

        int lastCanJumpIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= nums.length - 1) {
                lastCanJumpIndex = i;
            }
        }

        return lastCanJumpIndex == 0 ? true : false;
    }

    HashMap<Integer, Boolean> indexToCanJump = new HashMap<>();

    public boolean canJumpAlernate(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        return simulateJump(nums, 0);
    }

    public boolean simulateJump(int[] nums, int index) {

        if (index == nums.length - 1) {
            return true;
        }
        if (index >= nums.length) {
            return false;
        }

        boolean canJump = false;

        int maxIndex = Math.min(index + nums[index], nums.length);
        for (int nextIndex = maxIndex; nextIndex > index; nextIndex--) {
            if (indexToCanJump.containsKey(index)) {
                canJump |= indexToCanJump.get(index);
            } else {
                canJump |= simulateJump(nums, nextIndex);
            }
            if (canJump) {
                break;
            }
        }

        indexToCanJump.put(index, canJump);

        return canJump;
    }

    public static void main(String[] args) {

        int[] nums = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 0 };
        System.out.println(new JumpGame().canJump(nums));

    }

}