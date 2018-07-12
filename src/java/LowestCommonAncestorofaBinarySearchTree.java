package java;

/**
 * Created by haileyyin on 5/2/18.
 */
public class LowestCommonAncestorofaBinarySearchTree {
    /*
        dfs: recursion
        base case: root == null
        recursive rule:
             case 0: root.val == p.val || root.val == q.val, return root
             case 1: LCA(root.left) not null && LCA(root.right) not null, return root
             case 2: LCA(root.left) not null || LCA(root.right) not null, return not null value
             case 3: LCA(root.left)     null && LCA(root.right)     null, return null
        */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) { // base case
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p ,q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
