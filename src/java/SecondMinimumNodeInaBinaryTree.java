package java;

/**
 * Created by haileyyin on 7/11/18.
 */
public class SecondMinimumNodeInaBinaryTree {
    /*
    dfs: recursion
    */
    public int findSecondMinimumValue(TreeNode root) {
        return helper(root, root.val);
    }

    private int helper(TreeNode root, int min) {
        if (root == null) {  // base case
            return -1;
        }
        if (root.val != min) {
            return root.val;
        }
        int findLeft = helper(root.left, min);
        int findRight = helper(root.right, min);
        if (findLeft == -1 && findRight == -1) {
            return -1;
        } else if (findLeft != -1 && findRight != -1) {
            return Math.min(findLeft, findRight);
        }
        return findLeft == -1 ? findRight : findLeft;

    }
}
