package leetcode.tree;

import java.util.ArrayList;

/* https://leetcode.com/problems/binary-search-tree-iterator/ */
/* Runtime: 15 ms, faster than 75.71% Memory Usage: 42.8 MB, less than 96.23% */
public class BinarySearchTreeIterator {
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

    class BSTIterator {

        int index = 0;

        ArrayList<Integer> values = new ArrayList<>();

        public BSTIterator(TreeNode root) {
            traverseDfs(root);
        }

        public int next() {

            return index < values.size() ? values.get(index++) : 0;
        }

        public boolean hasNext() {

            return index < values.size() ? true : false;
        }

        public void traverseDfs(TreeNode root) {
            if (root == null) {
                return;
            }

            traverseDfs(root.left);
            values.add(root.val);
            traverseDfs(root.right);

        }
    }

}
