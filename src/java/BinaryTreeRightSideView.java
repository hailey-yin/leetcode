package java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by haileyyin on 5/12/18.
 */
public class BinaryTreeRightSideView {
    /*
        BFS
        */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0 ; i<size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right !=null)
                    queue.offer(cur.right);
                if (i==size-1)
                    res.add(cur.val);
            }
        }
        return res;
    }
    /*
    DFS, from right to left
     */
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }
}
