package leetcode.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * AllElementsInBST
 */
public class AllElementsInBST {

    static AllElementsInBST aeib = new AllElementsInBST();

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        traverseTree(root1, queue1);
        traverseTree(root2, queue2);

        List<Integer> solution = new ArrayList<>();

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int var;
            if (queue1.peek() > queue2.peek()) {
                var = queue2.poll();
            } else {
                var = queue1.poll();
            }

            solution.add(var);

        }

        Queue<Integer> nonEmptyQueue = queue1.isEmpty() ? queue2 : queue1;

        solution.addAll(nonEmptyQueue);

        return solution;

    }

    public void traverseTree(TreeNode root, Queue<Integer> queue) {

        if (root == null) {
            return;
        }

        traverseTree(root.left, queue);
        queue.add(root.val);
        traverseTree(root.right, queue);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root1 = stringToTreeNode(line);
            line = in.readLine();
            TreeNode root2 = stringToTreeNode(line);

            List<Integer> ret = new AllElementsInBST().getAllElements(root1, root2);

            String out = integerArrayListToString(ret);

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
        TreeNode root = aeib.new TreeNode(Integer.parseInt(item));
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
                node.left = aeib.new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = aeib.new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

}