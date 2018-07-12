package java;

/**
 * Created by haileyyin on 6/27/18.
 */
public class BinaryTreeLongestConsecutiveSequence {
    /*
    recursion
    base case: root == null
    M[root] represents the longest consecutive path from root.
    recursion rule: M[root] = max (M[root.left], M[root.right])
    Time: O(n)
    Space: O(logn)(height of the tree)
    */
    int max = Integer.MIN_VALUE;
    public int longestConsecutive(TreeNode root) {
        int maxFromRoot = helper(root);
        return Math.max(max, maxFromRoot);
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = helper(root.left);
        int rightMax = helper(root.right);
        if (leftMax != 0 && root.val == root.left.val - 1) {
            leftMax += 1;
        } else {
            leftMax = 1;
        }
        if (rightMax != 0 && root.val == root.right.val - 1) {
            rightMax += 1;
        } else {
            rightMax = 1;
        }
        max = Math.max(max, Math.max(leftMax, rightMax));
        return Math.max(leftMax, rightMax);
    }
}
