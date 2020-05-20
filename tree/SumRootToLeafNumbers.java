package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/sum-root-to-leaf-numbers/ */
public class SumRootToLeafNumbers {

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

    public int sumNumbers(TreeNode root) {

        List<StringBuilder> solutions = calculateSumNumbers(root);

        int sum = 0;

        for (StringBuilder solution : solutions) {
            sum += Integer.valueOf(solution.toString());
        }

        return sum;
    }

    public List<StringBuilder> calculateSumNumbers(TreeNode root) {

        List<StringBuilder> solution = new ArrayList<>();
        if (root == null) {
            return solution;
        }

        List<StringBuilder> leftSolution = calculateSumNumbers(root.left);

        List<StringBuilder> rightSolution = calculateSumNumbers(root.right);

        if (leftSolution.isEmpty() && rightSolution.isEmpty()) {
            StringBuilder temp = new StringBuilder();
            temp.append(root.val);
            solution.add(temp);
        } else {
            solution.addAll(leftSolution);
            solution.addAll(rightSolution);

            for (StringBuilder temp : solution) {
                temp.insert(0, root.val);
            }
        }

        return solution;

    }

}