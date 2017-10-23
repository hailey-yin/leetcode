package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class MaximumDepthofBinaryTree {
    /*
    对左右子树求取最大值，然后+1
     */
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
