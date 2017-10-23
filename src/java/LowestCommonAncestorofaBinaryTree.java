package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class LowestCommonAncestorofaBinaryTree {
    /*
    count(root.right)+
    count(root.left)+
    If root==q or q 就+1

    max=3找到
     */
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root,0);
    }

    private int sumNumbers(TreeNode root, int sum){
        if(root==null) return 0;
        sum = sum*10 + root.val;
        if(root.left==null&&root.right==null){
            return sum;
        }
        return sumNumbers(root.left,sum)+sumNumbers(root.right,sum);
    }
}
