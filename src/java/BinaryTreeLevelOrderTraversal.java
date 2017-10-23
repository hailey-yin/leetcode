package java;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by haileyyin on 10/22/17.
 */
public class BinaryTreeLevelOrderTraversal {
    /*
    Level -> BFS

    方法一：queue
    方法二：list
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
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
            list.add(subList);
        }
        return list;
    }
}
