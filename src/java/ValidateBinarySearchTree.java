package java;

import java.util.Stack;

/**
 * Created by haileyyin on 10/22/17.
 */
public class ValidateBinarySearchTree {
    /*
    方法一：
    根据题目中的定义来实现，其实就是对于每个结点保存左右界。
    All values on the left sub tree must be less than root, and all values on the right sub tree must be greater than root.
    So we just check the boundaries for each node.

    方法二：中序遍历得到int[]，再遍历数组看是否递增
     */

    public boolean isValidBST1(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, long min, long max){
        if(root==null) return true;

        if(root.val<=min || root.val>=max) return false;

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }

    public boolean isValidBST2(TreeNode root) {
        if(root==null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root!=null || !stack.empty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(pre!=null && root.val<=pre.val) return false;
            pre=root;
            root=root.right;
        }
        return true;
    }
}
