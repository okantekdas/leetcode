package leetcode.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/* https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/ */
public class VerticalOrderTraversalOfABinaryTree {

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

    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> solution = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        verticalTraversal(root, 0, 0);
        List<List<Integer>> s = new ArrayList<>();

        for (int xKey : solution.keySet()) {
            List<Integer> ss = new ArrayList<>();
            for (int yKey : solution.get(xKey).keySet()) {
                int size = solution.get(xKey).get(yKey).size();
                for (int i = 0; i < size; i++) {
                    ss.add(solution.get(xKey).get(yKey).poll());
                }
            }
            s.add(ss);
        }

        return s;

    }

    public void verticalTraversal(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }
        TreeMap<Integer, PriorityQueue<Integer>> xSolution = solution.get(x);
        if (xSolution == null) {
            xSolution = new TreeMap<>(Collections.reverseOrder());
            solution.put(x, xSolution);
        }
        PriorityQueue<Integer> ySolution = xSolution.get(y);
        if (ySolution == null) {
            ySolution = new PriorityQueue<>();
            xSolution.put(y, ySolution);
        }
        ySolution.add(root.val);
        verticalTraversal(root.left, x - 1, y - 1);
        verticalTraversal(root.right, x + 1, y - 1);

    }

    static VerticalOrderTraversalOfABinaryTree mdobt = new VerticalOrderTraversalOfABinaryTree();

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            mdobt.verticalTraversal(root);
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
        TreeNode root = mdobt.new TreeNode(Integer.parseInt(item));
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
                node.left = mdobt.new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = mdobt.new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

}