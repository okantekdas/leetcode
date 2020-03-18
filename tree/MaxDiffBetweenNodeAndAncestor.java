package leetcode.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * MaxDiffBetweenNodeAndAncestor
 */
public class MaxDiffBetweenNodeAndAncestor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Result {
        int min;
        int max;

        Result(int lowest, int highest) {
            min = lowest;
            max = highest;
        }
    }

    public int maxAncestorDiff(TreeNode root) {
        findResults(root);

        return maxDiff;

    }

    int maxDiff = 0;

    public Result findResults(TreeNode root) {
        if (root == null) {
            return null;
        }

        Result leftResult = findResults(root.left);
        Result rightResult = findResults(root.right);

        Result optimalResult = new Result(root.val, root.val);
        findOptimalResult(leftResult, optimalResult, rightResult);

        int localMaxDiff1 = Math.abs(root.val - optimalResult.min);
        int localMaxDiff2 = Math.abs(root.val - optimalResult.max);
        int localMaxDiff = localMaxDiff1 > localMaxDiff2 ? localMaxDiff1 : localMaxDiff2;
        if (maxDiff < localMaxDiff) {
            maxDiff = localMaxDiff;
        }

        return optimalResult;

    }

    public Result findOptimalResult(Result left, Result parent, Result right) {

        Result optimal = parent;

        if (left != null) {
            if (left.min < optimal.min) {
                optimal.min = left.min;
            }
            if (left.max > optimal.max) {
                optimal.max = left.max;
            }
        }

        if (right != null) {
            if (right.min < optimal.min) {
                optimal.min = right.min;
            }
            if (right.max > optimal.max) {
                optimal.max = right.max;
            }
        }

        return optimal;

    }

    static MaxDiffBetweenNodeAndAncestor mdbna = new MaxDiffBetweenNodeAndAncestor();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = mdbna.maxAncestorDiff(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = mdbna.new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = mdbna.new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = mdbna.new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

}