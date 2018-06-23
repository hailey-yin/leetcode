package java;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by haileyyin on 5/12/18.
 */
public class BinaryTreePreorderTraversal {
    /*
    1                3
    2            4       5
    3          6  5     6  8    n leaf nodes
    2^h=n, h=logn
    at level i, there is at most 2^(i-1) nodes
    how many child nodes does the root have?
    4 + (4+2) + (4+2+1)
    n + (n+n/2) + (n+n/2+n/4) + ... + (n+n/2+n/4+...+1) = O(nlogn)
    recursion
    time: O(nlogn)
    space: O(logn)
    */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        if (root.left != null) {
            List<Integer> leftPreorder = preorderTraversal(root.left);
            res.addAll(leftPreorder);
        }
        if (root.right != null) {
            List<Integer> rightPreorder = preorderTraversal(root.right);
            res.addAll(rightPreorder);
        }
        return res;
    }
    /*
    how to use iteration solve the problem?

    1                3
    2            4       5
    3          6  5     6  8    n leaf nodes

    stack: push right child first, then left child
    res: 3 4 6 5 5
    */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right !=null)
                stack.push(cur.right);
            if (cur.left !=null)
                stack.push(cur.left);
        }
        return res;
    }
}
