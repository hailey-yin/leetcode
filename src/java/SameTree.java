package java;

/**
 * Created by haileyyin on 10/22/17.
 */

public class SameTree {
    /*
    判断每个节点与其在另一棵树的对应节点的val和子节点数量是否相同。如果都相同，再递归判断子节点。直到比较完所有节点都是一样的，return true。
     */
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null ^ q == null) return false;
        return p.val == q.val && isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
        }
        return false;
    }
}
