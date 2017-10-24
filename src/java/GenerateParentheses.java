package java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 10/23/17.
 */
public class GenerateParentheses {
    /*
    This solution is simple and clear.
    In the dfs() method, left stands for the current number of (, right stands for the current number of ).

    如何保证这个combination是well-formed？在插入过程中的任何时候：
    1. 只要"("的数量没有超过n，都可以插入"("。
    2. 而可以插入")"的前提则是当前的"("数量必须要多余当前的")"数量。
     */

    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        dfs("", 0,0, n, ans);
        return ans;
    }

    private void dfs(String str, int left, int right, int n, List<String> ans){
        if(str.length()==2*n){
            ans.add(str);
            return;
        }
        if(left<n){
            dfs(str+"(", left+1, right, n, ans);
        }
        if(right<left){
            dfs(str+")", left, right+1, n, ans);
        }
    }
}
