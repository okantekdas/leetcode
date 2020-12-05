package leetcode.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/house-robber-iii/ */
/* Runtime: 3 ms, faster than 40.78% Memory Usage: 38.3 MB, less than 95.45% */
public class HouseRobber3 {
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

    HashMap<TreeNode, Integer> robbedNodeToMax = new HashMap<>();
    HashMap<TreeNode, Integer> notRobbedNodeToMax = new HashMap<>();

    public int rob(TreeNode root) {
        return rob(root, false);
    }

    public int rob(TreeNode root, boolean isAdjacentRobbered) {
        if (root == null) {
            return 0;
        }

        int max = 0;
        if (isAdjacentRobbered) {
            if (robbedNodeToMax.containsKey(root)) {
                return robbedNodeToMax.get(root);
            }
            int notRobbed = rob(root.left, false) + rob(root.right, false);
            max = notRobbed;
            robbedNodeToMax.put(root, max);
        } else {
            if (notRobbedNodeToMax.containsKey(root)) {
                return notRobbedNodeToMax.get(root);
            }
            int notRobbed = rob(root.left, false) + rob(root.right, false);
            int robbed = rob(root.left, true) + rob(root.right, true) + root.val;
            int localMax = Math.max(notRobbed, robbed);
            max = Math.max(max, localMax);
            notRobbedNodeToMax.put(root, max);

        }
        return max;
    }

    static HouseRobber3 hr = new HouseRobber3();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = hr.rob(root);

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
        TreeNode root = hr.new TreeNode(Integer.parseInt(item));
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
                node.left = hr.new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = hr.new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}
