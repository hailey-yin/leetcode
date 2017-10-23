package java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 10/22/17.
 */
public class CombinationSumII {
    //在Combination Sum 基础上，每层递归扫描时排除重复的数字。
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> tempRes, int[] candidates, int remains, int start){
        if(remains<0){
            return;
        } else if(remains==0){
            res.add(new ArrayList<>(tempRes));
        } else {
            for(int i=start; i<candidates.length; i++){
                if(i>start && candidates[i]==candidates[i-1]) continue;
                tempRes.add(candidates[i]);
                backtrack(res, tempRes, candidates, remains-candidates[i], i+1);
                tempRes.remove(tempRes.size()-1);
            }
        }
    }
}
