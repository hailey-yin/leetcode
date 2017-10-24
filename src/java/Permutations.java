package java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 10/23/17.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans  = new LinkedList<>();
        dfs(new LinkedList<>(), nums, ans);
        return ans;
    }

    private void dfs(List<Integer> curr, int[] nums, List<List<Integer>> ans){
        if(curr.size()==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int num:nums){
            if(!curr.contains(num)){
                curr.add(num);
                dfs(curr, nums, ans);
                curr.remove(curr.size()-1);
            }
        }
    }
}
