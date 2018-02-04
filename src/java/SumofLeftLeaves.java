package java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by haileyyin on 2/1/18.
 */
public class SumofLeftLeaves {
    /*
    recursion
    the point is that we need to find the node whose left child is not null and is a leaf.
    If it is the case, we add the leaf's value.
    Otherwise, recursion on root's left child.

    At last, recursion on root's right child.
    */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;
        int ans = 0;
        if(root.left!=null){
            if(root.left.left==null&&root.left.right==null){
                ans += root.left.val; //root.left is a leaf
            } else {
                ans += sumOfLeftLeaves(root.left);
            }
            ans += sumOfLeftLeaves(root.right);
        }
        return ans;
    }
    /*
    BFS
    */
    public int sumOfLeftLeaves2(TreeNode root) {
        if(root==null || root.left==null && root.right==null)
            return 0;
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeNode node = queue.poll();
            for(int i=0; i<size; i++){
                if(node.left!=null && node.left.left==null && node.left.right==null){
                    ans += node.left.val;
                }
                if(node.left!=null) {
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }
}
