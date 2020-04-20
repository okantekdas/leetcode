package leetcode.tree;

/* https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/ */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {

        return initilializeTree(pre, post, 0, pre.length - 1, 0, pre.length - 1);
    }

    public TreeNode initilializeTree(int[] pre, int[] post, int preLeft, int preRight, int postLeft, int postRight) {

        if (preLeft > preRight || postLeft > postRight) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);

        if (preLeft == preRight) {
            return root;
        }
        preLeft++;

        int index = postLeft;

        while (index <= postRight && post[index] != pre[preLeft]) {
            index++;
        }

        root.left = initilializeTree(pre, post, preLeft, preLeft + index - postLeft, postLeft, index);
        root.right = initilializeTree(pre, post, preLeft + index - postLeft + 1, preRight, index + 1, postRight - 1);

        return root;

    }

    public static void main(String[] args) {

        // int[] pre = { 2, 1 };
        // int[] post = { 1, 2 };
        int[] pre = { 3, 4, 2, 1 };
        int[] post = { 2, 1, 4, 3 };
        // int[] pre = { 1, 2, 4, 5, 3, 6, 7 };
        // int[] post = { 4, 5, 2, 6, 7, 3, 1 };

        TreeNode root = new ConstructBinaryTreeFromPreorderAndPostorderTraversal().constructFromPrePost(pre, post);
        int a = 5;
    }

}