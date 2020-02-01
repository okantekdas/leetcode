package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * MaxLevelSumOfBinaryTree
 */
public class MaxLevelSumOfBinaryTree {

    public static int maxLevelSum(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int maxTotal = Integer.MIN_VALUE;
        int maxLevel = 1;
        int currentLevel = 1;

        while (!queue.isEmpty()) {

            Queue<TreeNode> tempQueue = new LinkedList<>();

            int currentTotal = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();

                currentTotal += currentNode.val;
                if (currentNode.left != null) {
                    tempQueue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    tempQueue.add(currentNode.right);
                }

            }

            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                maxLevel = currentLevel;
            }

            queue.addAll(tempQueue);
            currentLevel++;
        }

        return maxLevel;
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(989);
        TreeNode node2 = null;
        TreeNode node3 = new TreeNode(10250);
        TreeNode node4 = new TreeNode(98693);
        TreeNode node5 = new TreeNode(-89388);
        TreeNode node6 = null;
        TreeNode node7 = null;
        TreeNode node8 = null;
        TreeNode node9 = new TreeNode(-32127);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        node4.left = node6;
        node4.right = node7;

        node5.left = node8;
        node5.right = node9;

        System.out.println(maxLevelSum(node1));

    }
}