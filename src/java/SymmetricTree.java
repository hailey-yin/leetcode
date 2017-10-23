package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class SymmetricTree {
    /*
    根结点，调用函数判断左子树和右子树是否对称。
    开始递归调用函数判断：
    左边节点的左子树 与 右边节点的右子树 是否对称
    左边节点的右子树 与 右边节点的左子树 是否对称
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricTree(root.left, root.right);
    }

    public boolean isSymmetricTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
        {
            return true;
        }
        else if(p == null && q != null)
        {
            return false;
        }
        else if(q == null && p != null)
        {
            return false;
        }
        return p.val == q.val && isSymmetricTree(p.left, q.right) && isSymmetricTree(p.right, q.left);
    }
}
