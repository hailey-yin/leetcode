package java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 7/13/18.
 */
public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        while (root != null) {
            List<Integer> cur = new LinkedList<>();
            boolean nextIsLeave = helper(root, cur);
            ans.add(cur);
            if (nextIsLeave) {
                break;
            }
        }
        return ans;
    }
    private boolean helper(TreeNode root, List<Integer> cur) {
        if (root.left == null && root.right == null) {
            cur.add(root.val);
            return true;
        }
        if(root.left != null) {
            boolean nextIsLeave = helper(root.left, cur);
            if (nextIsLeave) {
                root.left = null;
            }
        }
        if(root.right != null) {
            boolean nextIsLeave = helper(root.right, cur);
            if (nextIsLeave) {
                root.right = null;
            }
        }
        return false;
    }
}
