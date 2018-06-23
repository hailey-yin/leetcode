package java;

/**
 * Created by haileyyin on 5/1/18.
 */

import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        if (root!=null) {
            stack.push(root);
            while (root!=null && root.left!=null) {
                stack.push(root.left);
                root = root.left;
            }
        }

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int ans = node.val;
        if (node.right!=null) {
            node = node.right;
            stack.push(node);
            while (node.left!=null) {
                stack.push(node.left);
                node = node.left;
            }
        }
        return ans;
    }
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
