package java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 3/27/18.
 */
public class BinaryTreePaths {
    /*
    DFS
    recursion
    */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<Integer>();
        if(root!=null)
            cur.add(root.val);
        dfs(root, cur, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> cur, List<String> res){
        if(root==null)
            return;
        if(root.left==null&&root.right==null){
            StringBuilder sb = new StringBuilder();
            for(int i:cur){
                sb.append(i);
                sb.append("->");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
        }

        if(root.left!=null){
            cur.add(root.left.val);
            dfs(root.left, cur, res);
            cur.remove(cur.size()-1);
        }
        if(root.right!=null){
            cur.add(root.right.val);
            dfs(root.right, cur, res);
            cur.remove(cur.size()-1);
        }
    }
    /*
    iteration
     */
    public List<String> binaryTreePaths2(TreeNode root) {

        List<String> paths = new LinkedList<>();

        if(root == null) return paths;

        if(root.left == null && root.right == null){
            paths.add(root.val+"");
            return paths;
        }

        for (String path : binaryTreePaths(root.left)) {
            paths.add(root.val + "->" + path);
        }

        for (String path : binaryTreePaths(root.right)) {
            paths.add(root.val + "->" + path);
        }

        return paths;

    }
}
