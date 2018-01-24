package java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by haileyyin on 1/21/18.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root==null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()){
            List<Integer> cur = new LinkedList<>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode temp = queue.poll();
                if(depth%2==0){
                    cur.add(temp.val);
                } else {
                    cur.add(0, temp.val);
                }
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            ans.add(cur);
            depth++;
        }
        return ans;
    }
}
