package java;

import java.util.Stack;

/**
 * Created by haileyyin on 10/22/17.
 */
public class FlattenBinaryTreetoLinkedList {
    /*
    方法一：
    找到递增序列中根结点之前的点，将根结点右孩子接到该点的右孩子，将根结点左孩子移到右边。
     */
    public void flatten1(TreeNode root) {
        while(root!=null){
            if(root.left!=null){
                TreeNode temp = root.left;
                //找到根结点左子树的最大点
                while(temp.right!=null){
                    temp=temp.right;
                }
                //将根结点右子树拼接到该点右孩子
                temp.right=root.right;
                root.right=root.left;
                root.left=null;
            }
            root=root.right;
        }
        return;
    }
    /*
    方法二：
    先序遍历，递归。将左子树移到右边，左子树置空，提前保存原本的右孩子。维护全局变量，记录上个访问的结点。
     */
    private TreeNode prev = null;
    public void flatten2(TreeNode root) {
        if (root == null) return;
        flatten2(root.right);
        flatten2(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
    /*
    先序遍历，栈
     */
    public void flatten3(TreeNode root) {
        if(root==null) return;
        Stack<TreeNode> stack = new Stack<>();

        while(root!=null || !stack.isEmpty()){
            if(root.right!=null){
                stack.push(root.right);
            }
            if(root.left!=null){
                root.right=root.left;
                root.left=null;
            } else if(!stack.isEmpty()){
                root.right=stack.pop();
            }
            root=root.right;
        }
    }
}
