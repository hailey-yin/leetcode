package java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by haileyyin on 10/22/17.
 */
public class PathSum2 {
    /*
    输出所有满足要求的root-to-leaf路径。
    dfs，路径上的点累加，超过target停止，换下一条路径，直到遍历完所有路径。

    方法一：list
     */
    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root==null) return list;
        List<Integer> temp = new ArrayList<>();
        dfs(list, temp, root, sum);
        return list;
    }

    public void dfs(List<List<Integer>> list, List<Integer> temp, TreeNode root, int sum){
        temp.add(root.val);
        sum-=root.val;
        if(root.left==null && root.right==null && sum==0){
            List<Integer> l = new ArrayList<>();
            l.addAll(temp);
            list.add(l);
        }
        if(root.left!=null){
            dfs(list,temp,root.left,sum);
            temp.remove(temp.size()-1);
        }
        if(root.right!=null){
            dfs(list,temp,root.right,sum);
            temp.remove(temp.size()-1);
        }
    }

    /*
    update: 不存在超过target停止的情况，因为节点和sum的值可能为负数
     */
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        dfs(root, sum, new LinkedList<Integer>(), ans);
        return ans;
    }

    private void dfs(TreeNode root, int remain, List<Integer> curr, List<List<Integer>> ans){
        if(root.left==null && root.right==null && root.val==remain){
            curr.add(root.val);
            ans.add(new LinkedList(curr));
            curr.remove(curr.size()-1);
            return;
        }
        if(root.left!=null){
            curr.add(root.val);
            dfs(root.left, remain-root.val, curr, ans);
            curr.remove(curr.size()-1);
        }
        if(root.right!=null){
            curr.add(root.val);
            dfs(root.right, remain-root.val, curr, ans);
            curr.remove(curr.size()-1);
        }
    }
    /*
    方法二：stack
     */
    public List<List<Integer>> pathSum3(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root==null) return list;
        Stack<Integer> path = new Stack<Integer>();
        dfs(list, path, root, sum);
        return list;
    }

    public void dfs(List<List<Integer>> list, Stack<Integer> path, TreeNode root, int sum){
        path.push(root.val);
        sum-=root.val;
        if(root.left==null && root.right==null && sum==0){
            List<Integer> l = new ArrayList<>();
            l.addAll(path);
            list.add(l);
        }
        if(root.left!=null){
            dfs(list,path,root.left,sum);
            path.pop();
        }
        if(root.right!=null){
            dfs(list,path,root.right,sum);
            path.pop();
        }
    }
}
