package java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by haileyyin on 10/22/17.
 */
public class BinaryTreeLevelOrderTraversal2 {
    /*
    方法一：跟102正序bfs一样，只是每层从队头插入
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root==null) return list;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum=queue.size();
            List<Integer> subList=new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++){
                if(queue.peek().left!=null)
                    queue.offer(queue.peek().left);
                if(queue.peek().right!=null)
                    queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            list.add(0,subList);
        }
        return list;
    }
    /*
    方法二：递归。先为所有层开辟新空间，再将各节点放入与level相反的层数里。
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        helper(root, res, 0);
        return res;
    }
    public void helper(TreeNode root, List<List<Integer>> res, int level){
        if(root==null) return;
        if(res.size()==level){
            res.add(0, new ArrayList<>());
        }
        helper(root.left, res, level+1);
        helper(root.right, res, level+1);
        res.get(res.size()-level-1).add(root.val);
    }
}
