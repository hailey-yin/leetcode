package java;

/**
 * Created by haileyyin on 4/17/18.
 */
public class PathSum {
    /*
    dfs
    */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        return helper(root, sum, 0);
    }

    private boolean helper(TreeNode root, int sum, int cur){
        if(root==null)
            return false;
        cur += root.val;
        if(root.left==null&&root.right==null){
            if(sum==cur){
                return true;
            } else {
                return false;
            }
        }
        return helper(root.left, sum, cur) || helper(root.right, sum, cur);
    }
    /*
    a more concise way of coding
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null && sum - root.val == 0)
            return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
