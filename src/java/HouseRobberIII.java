package java;

/**
 * Created by haileyyin on 1/24/18.
 */
public class HouseRobberIII {
    /*
    wrong impression:
    sums up nodes at the same level into a total number, do this for each level and then it becomes to the rober house problem.
    */

    /*
    tree dynamic programming:
    f(root) represents maximum value if start from the root house
    g(root) represents maximum value if start from the root house and not broke the root house

    f(root) = max{f(root.left)+f(root.right), g(root.left)+ g(root.right)+root.val}
    g(root) = f(root.left)+f(root.right)
    */

    public int rob(TreeNode root) {
        return dfs(root)[0];
    }

    private int[] dfs(TreeNode root){
        int[] dp = new int[2]; //f, g
        if(root!=null){
            int[] dpl = dfs(root.left);
            int[] dpr = dfs(root.right);
            dp[1] = dpl[0] + dpr[0];
            dp[0] = Math.max(dp[1], dpl[1]+dpr[1]+root.val);
        }
        return dp;
    }
}
