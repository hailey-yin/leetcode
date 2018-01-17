package java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 1/16/18.
 */
public class Combinations {
    /*
    backtracking
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        helper(n, k, new LinkedList<Integer>(), ans);
        return ans;
    }

    private void helper(int n, int k, List<Integer> cur, List<List<Integer>> ans){
        if(n<k)
            return;
        if(k==0){
            ans.add(new LinkedList<Integer>(cur));
        } else {
            cur.add(n);
            helper(n-1, k-1, cur, ans);
            cur.remove(cur.size()-1);
            helper(n-1, k, cur, ans);
        }
    }
}
