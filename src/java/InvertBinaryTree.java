package java;

/**
 * Created by haileyyin on 5/2/18.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode right = null;
        if (root.right != null) {
            right = invertTree(root.right);
        }
        TreeNode left = null;
        if (root.left != null) {
            left = invertTree(root.left);
        }
        root.right = left;
        root.left = right;
        return root;
    }
}
