package java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by haileyyin on 11/7/17.
 */
public class AddOneRowtoTree {
    /*
    BFS
     */
    public TreeNode addOneRow1(TreeNode root, int v, int d) {
        if(d==1){
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int levelNum = 0;
        queue.offer(root);
        while(!queue.isEmpty() && d>2){
            levelNum = queue.size();
            for(int i=0; i<levelNum; i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            d--;
        }
        levelNum = queue.size();
        for(int i=0; i<levelNum; i++){
            TreeNode node = queue.poll();
            TreeNode left = new TreeNode(v);
            TreeNode right = new TreeNode(v);
            if(node.left!=null){
                left.left = node.left;
            }
            if(node.right!=null){
                right.right = node.right;
            }
            node.left = left;
            node.right = right;
        }
        return root;
    }

    /*
    DFS: recursion
     */
    public TreeNode addOneRow2(TreeNode root, int v, int d) {
        if(d==1){
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        helper(root, v, d, 1);
        return root;
    }

    private void helper(TreeNode root, int v, int d, int depth){
        if(root==null){
            return;
        }
        if(depth==d-1){
            TreeNode left = new TreeNode(v);
            TreeNode right = new TreeNode(v);
            if(root.left!=null){
                left.left = root.left;
            }
            if(root.right!=null){
                right.right = root.right;
            }
            root.left = left;
            root.right = right;
        } else {
            helper(root.left, v, d, depth+1);
            helper(root.right, v, d, depth+1);
        }
    }

    /*
    DFS: stack
    using new class Node
     */
    public TreeNode addOneRow3(TreeNode root, int v, int d) {
        if(d==1){
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(root,1));
        while(!stack.isEmpty()){
            Node node = stack.pop();
            if(node.root==null){
                continue;
            }
            if(node.depth==d-1){
                TreeNode left = new TreeNode(v);
                TreeNode right = new TreeNode(v);
                if(node.root.left!=null){
                    left.left = node.root.left;
                }
                if(node.root.right!=null){
                    right.right = node.root.right;
                }
                node.root.left = left;
                node.root.right = right;
            } else {
                stack.push(new Node(node.root.left, node.depth+1));
                stack.push(new Node(node.root.right, node.depth+1));
            }
        }
        return root;
    }
}
