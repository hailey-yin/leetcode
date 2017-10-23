package java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by haileyyin on 10/22/17.
 */
public class BinaryTreeInorderTraversal {
    /*
    中序遍历
    方法一：stack, iterative
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Stack<TreeNode> stack = new Stack<>();

        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root=root.right;
        }
        return res;
    }
    /*
    方法二：递归
     */
    public List<Integer> inorderTraversal2(TreeNode root) {

        if (root == null) return new ArrayList<Integer>();

        List<Integer> left_list = inorderTraversal2(root.left);
        left_list.add(root.val);
        List<Integer> right_list = inorderTraversal2(root.right);
        left_list.addAll(right_list);
        return left_list;
    }
    /*
    方法三：通用
     */
    public class Pair {
        int visit;
        TreeNode node;
        Pair(int visit, TreeNode node){
            // 0 means not visited which represents we haven't explore its children,
            // 1 means its' children are in stack.
            this.visit = visit;
            this.node = node;
        }
    }


    public List<Integer> inorderTraversal3(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(0,root));

        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            if(pair.visit==0){
                //访问其子节点
                if(pair.node.right!=null){
                    stack.push(new Pair(0, pair.node.right));
                }
                stack.push(new Pair(1, pair.node));
                if(pair.node.left!=null){
                    stack.push(new Pair(0, pair.node.left));
                }
            } else {
                res.add(pair.node.val);
            }
        }

        List<Integer> left_list = inorderTraversal3(root.left);
        left_list.add(root.val);
        List<Integer> right_list = inorderTraversal3(root.right);
        left_list.addAll(right_list);
        return left_list;
    }
}
