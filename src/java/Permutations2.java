package java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 10/23/17.
 */
public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        backtracking(new LinkedList<>(), nums, new boolean[nums.length], ans);
        return ans;
    }

    private void backtracking(List<Integer> curr, int[] nums, boolean[] used, List<List<Integer>> ans){
        if(curr.size()==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i<nums.length; i++){
            //used[i-1]==false表示状态都还原，说明以这个数为根的子树已经有遍历完了，可以跳过。
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1])
                continue;
            curr.add(nums[i]);
            used[i] = true;
            backtracking(curr, nums, used, ans);
            used[i] = false;
            curr.remove(curr.size()-1);
        }
    }
}
