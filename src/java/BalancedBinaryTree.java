package java;

/**
 * Created by haileyyin on 4/17/18.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(getDepth(root.right)-getDepth(root.left))<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }

    private int getDepth(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(getDepth(root.right), getDepth(root.left))+1;
    }
}
