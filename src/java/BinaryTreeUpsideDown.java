package java;

/**
 * Created by haileyyin on 4/19/18.
 */
public class BinaryTreeUpsideDown {
    /*
    iterative solution
    Time: O(n)
    Space: O(1)
    */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode next = null;
        //temp to keep the previous right child
        TreeNode temp = null;
        while(cur!=null){
            next = cur.left;
            cur.left = temp;
            temp = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    /*
    recursive solution
    Time: O(n)
    Space: O(n)
    */
    public TreeNode upsideDownBinaryTree2(TreeNode root) {
        if(root==null||root.left==null)
            return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
