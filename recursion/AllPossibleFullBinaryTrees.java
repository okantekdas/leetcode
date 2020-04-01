package leetcode.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * AllPossibleFullBinaryTrees
 */
public class AllPossibleFullBinaryTrees {

    public class TreeNode implements Cloneable {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    HashMap<Integer, List<TreeNode>> nToList = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        if (nToList.get(N) != null) {
            return nToList.get(N);
        }
        List<TreeNode> solution = new ArrayList<>();
        if (N == 1) {
            solution.add(new TreeNode(0));
            nToList.put(N, solution);
            return solution;
        }

        if (N == 0 || N % 2 == 0) {
            return solution;
        }

        for (int i = 1; i < N; i += 2) {
            List<TreeNode> leftSubSolution = allPossibleFBT(i);
            List<TreeNode> rightSubSolution = allPossibleFBT(N - i - 1);

            for (TreeNode left : leftSubSolution) {
                for (TreeNode right : rightSubSolution) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;

                    solution.add(root);
                }
            }
        }

        nToList.put(N, solution);

        return solution;

    }

    public static void main(String[] args) {

        List<TreeNode> solution = new AllPossibleFullBinaryTrees().allPossibleFBT(7);

        int a = 7;

    }

}