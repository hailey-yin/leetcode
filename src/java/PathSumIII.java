package java;

/**
 * Created by haileyyin on 2/5/18.
 */
public class PathSumIII {
    /*
    we need to do dfs recursion and pathSum recursion both.
    */
    public int pathSum(TreeNode root, int sum) {
        int count = 0;
        if(root==null)
            return count;
        count += dfs(root, sum);
        count += pathSum(root.left, sum);
        count += pathSum(root.right, sum);
        return count;
    }

    private int  dfs(TreeNode root, int remain){
        int count = 0;
        if(root==null)
            return count;
        if(remain==root.val){
            count++;
        }
        count += dfs(root.left, remain-root.val);
        count += dfs(root.right, remain-root.val);
        return count;
    }
}
