package leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ZigZagLevelOrderTraversal
 */
public class BinaryTreeZigZagLevelOrderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> solution = new ArrayList<>();
        if (root == null) {
            return solution;
        } else {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            boolean zigzag = false;
            queue.add(root);
            while (!queue.isEmpty()) {

                List<Integer> innerSolution = new ArrayList<>();

                int currentSize = queue.size();

                for (int i = 0; i < currentSize; i++) {

                    TreeNode current = queue.poll();

                    if (zigzag) {

                        innerSolution.add(0, current.val);

                    } else {
                        innerSolution.add(current.val);
                    }

                    if (current.left != null) {
                        queue.add(current.left);
                    }
                    if (current.right != null) {
                        queue.add(current.right);
                    }

                }

                solution.add(innerSolution);
                zigzag = zigzag == true ? false : true;

            }
        }
        return solution;

    }

    public static void main(String[] args) {

        BinaryTreeZigZagLevelOrderTraversal btzzlot = new BinaryTreeZigZagLevelOrderTraversal();

        TreeNode node1 = btzzlot.new TreeNode(3);
        TreeNode node2 = btzzlot.new TreeNode(9);
        TreeNode node3 = btzzlot.new TreeNode(20);
        TreeNode node4 = btzzlot.new TreeNode(15);
        TreeNode node5 = btzzlot.new TreeNode(7);
        // TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        List<List<Integer>> solution = zigzagLevelOrder(node1);

        System.out.println(Arrays.deepToString(solution.toArray()));

    }
}