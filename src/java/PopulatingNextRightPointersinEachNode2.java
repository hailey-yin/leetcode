package java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by haileyyin on 10/22/17.
 */
public class PopulatingNextRightPointersinEachNode2 {
    /*
    方法一：bfs，queue（优点：对二叉树没有要求）
     */

    public void connect1(TreeLinkNode root) {
        if(root==null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0; i<size; i++){
                if(queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    queue.offer(queue.peek().right);
                }
                TreeLinkNode precede = queue.poll();
                if(i!=size-1){
                    precede.next = queue.peek();
                } else {
                    precede.next = null;
                }
            }
        }
    }

    /*
    方法二：递归，将当前根结点的孩子从右到左连接好
     */

    public void connect2(TreeLinkNode root) {
        if(root==null) return;
        //找到root所在层下一个带孩子的节点
        TreeLinkNode node = root.next;
        while(node!=null){
            if(node.left==null && node.right==null){
                node=node.next;
            } else
                break;
        }
        if(node!=null){
            node=(node.left==null)?node.right:node.left;
        }
        if(root.right!=null){
            root.right.next=node;
        }
        if(root.left!=null){
            root.left.next=(root.right==null)?node:root.right;
        }
        connect2(root.right);
        connect2(root.left);
    }
}
