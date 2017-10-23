package java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 10/21/17.
 */
public class CombinationSum {
    /*
    递归：
    Sort the array first.
    For each candidates[I], recursively find the combination that sum to target-candidate[I] in the   [I, n-1] sub-array.

    如果选定一个candidates[i]，则需要继续寻找和为target-candidate[i]的combination。由于candidates和target都为正数，当和超过或等于target时，查找中止。对candidate排序，并且每层递归扫描的时候需要做到去重复解：
    1. 不回头扫，在扫描candidates[i]时，对candidate[i: n-1]递归查找target-candidates[i]。
    2. 每层扫描的时候跳过重复的candidates。
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                tempRes.add(candidates[i]);
                backtrack(res, tempRes, candidates, remains-candidates[i], i);
                tempRes.remove(tempRes.size()-1);
            }
        }
    }
}
