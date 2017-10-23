package java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by haileyyin on 10/22/17.
 */
public class KthSmallestElementinaBST {
    /*
    中序遍历时维护一个函数i记录当前已经输出多少元素，当i=k时结束中序遍历。
    方法一：
     */
    public int kthSmalles1t(TreeNode root, int k) {
        if (root==null) return 0;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.empty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(--k==0) break;
            root=root.right;
        }
        return root.val;
    }

    /*
    recursive inorder traverse
     */
    private int count;
    private int target;
    public int kthSmallest2(TreeNode root, int k) {
        count = k;
        inorder(root);
        return target;
    }
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (count == 1) target = root.val;
        count--;
        inorder(root.right);
    }
}
