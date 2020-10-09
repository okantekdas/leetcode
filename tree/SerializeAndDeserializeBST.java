package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/serialize-and-deserialize-bst/ */
/* Runtime: 8 ms, faster than 57.16% Memory Usage: 39.8 MB, less than 7.96% */
public class SerializeAndDeserializeBST {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder strBuilder = new StringBuilder();
            if (root == null) {
                return strBuilder.toString();
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node == null) {
                        strBuilder.append(",").append("N");

                    } else {
                        if (strBuilder.length() != 0) {
                            strBuilder.append(",");
                        }
                        strBuilder.append(node.val);
                        queue.add(node.left);
                        queue.add(node.right);
                    }

                }
            }

            return strBuilder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) {
                return null;
            }
            String[] dataArr = data.split(",");
            Queue<TreeNode> queue = new LinkedList<>();

            TreeNode root = new TreeNode(Integer.valueOf(dataArr[0]));
            queue.add(root);

            int index = 1;
            while (!queue.isEmpty()) {
                TreeNode parent = queue.poll();

                if (!dataArr[index].equals("N")) {
                    TreeNode left = new TreeNode(Integer.valueOf(dataArr[index]));
                    parent.left = left;
                    queue.add(left);
                }
                index++;
                if (!dataArr[index].equals("N")) {
                    TreeNode right = new TreeNode(Integer.valueOf(dataArr[index]));
                    parent.right = right;
                    queue.add(right);
                }
                index++;
            }

            return root;
        }

    }
}
