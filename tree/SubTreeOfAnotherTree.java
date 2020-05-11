package leetcode.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/subtree-of-another-tree */
public class SubTreeOfAnotherTree {

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

    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (s == null) {
            return false;
        }

        boolean subsolution = false;
        if (s.val == t.val) {
            subsolution |= checkIfSubtree(s, t);
        }
        if (!subsolution) {
            subsolution |= isSubtree(s.left, t);
            if (!subsolution) {
                subsolution |= isSubtree(s.right, t);
            }
        }

        return subsolution;

    }

    public boolean checkIfSubtree(TreeNode s, TreeNode t) {

        if (s == null && t == null) {
            return true;
        }
        if (s != null && t == null) {
            return false;
        }
        if (s == null && t != null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return checkIfSubtree(s.left, t.left) && checkIfSubtree(s.right, t.right);
    }

    static SubTreeOfAnotherTree stat = new SubTreeOfAnotherTree();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode s = stringToTreeNode(line);
            line = in.readLine();
            TreeNode t = stringToTreeNode(line);

            boolean ret = stat.isSubtree(s, t);

            String out = booleanToString(ret);

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
        TreeNode root = stat.new TreeNode(Integer.parseInt(item));
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
                node.left = stat.new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = stat.new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

}