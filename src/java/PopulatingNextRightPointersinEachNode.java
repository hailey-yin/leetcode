package java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by haileyyin on 10/22/17.
 */
public class PopulatingNextRightPointersinEachNode {
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
    方法二：递归，将当前根结点的孩子从左到右连接好（缺点：必须是perfect二叉树）
     */
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        if(root.left!=null){
            root.left.next=root.right;
        }
        if(root.right!=null){
            root.right.next=(root.next==null)?null:root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
}
