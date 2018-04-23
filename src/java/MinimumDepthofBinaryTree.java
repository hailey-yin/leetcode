package java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by haileyyin on 4/17/18.
 */
public class MinimumDepthofBinaryTree {
    /*
    BFS
    */
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        boolean found = false;
        while(!queue.isEmpty()&&!found){
            res++;
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode temp = queue.poll();
                if(temp.left==null&&temp.right==null){
                    found = true;
                    break;
                }
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
        }
        return res;
    }
}
