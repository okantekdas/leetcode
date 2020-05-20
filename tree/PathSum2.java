package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/path-sum-ii/ */
public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> solution = new ArrayList<>();

        if (root == null) {
            return solution;
        }

        List<List<Integer>> leftSolution = pathSum(root.left, sum - root.val);
        List<List<Integer>> rightSolution = pathSum(root.right, sum - root.val);

        if (root.left == null && root.right == null && sum - root.val == 0) {
            List<Integer> l = new ArrayList<>();
            l.add(root.val);
            solution.add(l);
            return solution;
        }

        for (List<Integer> list : leftSolution) {
            List<Integer> s = new ArrayList<>();
            s.add(root.val);
            s.addAll(list);
            solution.add(s);
        }

        for (List<Integer> list : rightSolution) {
            List<Integer> s = new ArrayList<>();
            s.add(root.val);
            s.addAll(list);
            solution.add(s);
        }

        return solution;
    }

}