package java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 1/24/18.
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        backtracking(k, 1, n, new LinkedList<Integer>(), ans);
        return ans;
    }

    private void backtracking(int k, int start, int remain, List<Integer> cur, List<List<Integer>> ans){
        if(k==0&&remain!=0)
            return;
        if(k==0&&remain==0){
            ans.add(new LinkedList<>(cur));
            return;
        }
        for(int i=start; i<10; i++){
            cur.add(i);
            backtracking(k-1, i+1, remain-i, cur, ans);
            cur.remove(cur.size()-1);
        }
    }
}
