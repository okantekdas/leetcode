package leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* https://leetcode.com/problems/unique-binary-search-trees-ii/ */
public class UniqueBinarySearchTrees2 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Interval {
        int left;
        int right;
    }

    HashMap<Interval, List<TreeNode>> intervalToList = new HashMap<>();

    public List<TreeNode> generateTrees(int n) {

        if (n == 0) {
            return new ArrayList<>();
        }

        int[] arr = new int[n];

        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        return calculateVariations(arr, 0, n - 1);

    }

    public List<TreeNode> calculateVariations(int[] arr, int left, int right) {
        List<TreeNode> solutions;
        if (left > right) {
            return null;
        }
        if (left == right) {
            solutions = new ArrayList<>();
            solutions.add(new TreeNode(left + 1));
            return solutions;
        }

        solutions = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            TreeNode root = new TreeNode(i + 1);
            List<TreeNode> leftSolution = calculateVariations(arr, left, i - 1);
            List<TreeNode> rightSolution = calculateVariations(arr, i + 1, right);

            cartesianProduct(root.val, leftSolution, rightSolution, solutions);

        }

        return solutions;
    }

    public List<TreeNode> cartesianProduct(int rootVal, List<TreeNode> leftSolution, List<TreeNode> rightSolution,
            List<TreeNode> solutions) {
        if (leftSolution == null || leftSolution.isEmpty()) {
            if (rightSolution != null && !rightSolution.isEmpty()) {
                for (TreeNode rightChild : rightSolution) {
                    TreeNode root = new TreeNode(rootVal);
                    root.right = rightChild;
                    solutions.add(root);
                }
            }
        } else {
            if (rightSolution == null || rightSolution.isEmpty()) {
                for (TreeNode leftChild : leftSolution) {
                    TreeNode root = new TreeNode(rootVal);
                    root.left = leftChild;
                    solutions.add(root);
                }
            } else {
                for (TreeNode leftChild : leftSolution) {
                    for (TreeNode rightChild : rightSolution) {
                        TreeNode root = new TreeNode(rootVal);
                        root.left = leftChild;
                        root.right = rightChild;
                        solutions.add(root);
                    }
                }
            }
        }

        return solutions;
    }

    public static void main(String[] args) {

        List<TreeNode> solution = new UniqueBinarySearchTrees2().generateTrees(3);

        System.out.println(solution.size());

    }

}