package leetcode.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/path-sum-iii/ */
public class PathSum3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        int solution = 0;
        if (root == null) {
            return solution;
        }
        solution += pathSumHelper(root, sum);

        solution += pathSum(root.left, sum);
        solution += pathSum(root.right, sum);

        return solution;
    }

    public int pathSumHelper(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }
        int solution = 0;

        solution += pathSumHelper(root.left, sum - root.val);
        solution += pathSumHelper(root.right, sum - root.val);
        if (sum - root.val == 0) {
            solution++;
        }
        return solution;
    }

    static PathSum3 ps3 = new PathSum3();

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            ps3.pathSum(root, 8);
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
        TreeNode root = ps3.new TreeNode(Integer.parseInt(item));
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
                node.left = ps3.new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = ps3.new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

}